package edu.matc.persistence;

import edu.matc.entity.CarbonFootprint;
import edu.matc.entity.User;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Root;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import java.time.LocalDate;
import java.util.List;

/**
 * The type Carbon footprint dao.
 */
public class CarbonFootprintDao {

    private final Logger logger = LogManager.getLogger(this.getClass());
    private final SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Gets carbon footprint entry by id.
     *
     * @param id the id
     * @return the by id
     */
    public CarbonFootprint getById(int id) {
        Session session = sessionFactory.openSession();
        CarbonFootprint entry = session.get(CarbonFootprint.class, id);
        session.close();
        return entry;
    }

    /**
     * Inserts a new carbon footprint entry.
     *
     * @param entry the entry
     * @return the int
     */
    public int insert(CarbonFootprint entry) {
        int id;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(entry);
        transaction.commit();
        session.close();
        return entry.getId();


    }

    /**
     * Update a carbon footprint entry.
     *
     * @param entry the entry
     */
    public void update(CarbonFootprint entry) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.merge(entry);
        transaction.commit();
        session.close();
    }

    /**
     * Delete a carbon footprint entry.
     *
     * @param entry the entry
     */
    public void delete(CarbonFootprint entry) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(entry);
        transaction.commit();
        session.close();

    }


    /**
     * Gets all carbon footprint entries.
     *
     * @return the all
     */
    public List<CarbonFootprint> getAll() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<CarbonFootprint> query = criteriaBuilder.createQuery(CarbonFootprint.class);
        Root<CarbonFootprint> root = query.from(CarbonFootprint.class);
        query.select(root);
        List<CarbonFootprint> entries = session.createQuery(query, CarbonFootprint.class).getResultList();
        session.close();
        return entries;
    }


    /**
     * Gets carbont footprint entries by date range.
     *
     * @param startDate the start date
     * @param endDate   the end date
     * @return the by date range
     */
    public List<CarbonFootprint> getByDateRange(LocalDate startDate, LocalDate endDate) {

        Session session = sessionFactory.openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery query = criteriaBuilder.createQuery();
        Root<CarbonFootprint> root = query.from(CarbonFootprint.class);
        query.select(root).where(criteriaBuilder.between(root.get("entryDate"), startDate, endDate));
        List<CarbonFootprint> entries = session.createQuery(query).getResultList();
        session.close();
        return entries;


    }
}
