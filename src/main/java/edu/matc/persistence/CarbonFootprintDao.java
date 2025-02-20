package edu.matc.persistence;

import edu.matc.entity.CarbonFootprint;
import edu.matc.entity.User;
import jakarta.persistence.criteria.*;
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
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(entry);
        transaction.commit();
        id = entry.getId();
        session.close();
        return id;


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
        List<CarbonFootprint> entries = session.createQuery(query).getResultList();
        session.close();
        return entries;
    }

    public List<CarbonFootprint> getEntriesByUserIdAndDate(int userId, LocalDate date) {
        Session session = sessionFactory.openSession();
        List<CarbonFootprint> entries = session.createQuery(
                        "FROM CarbonFootprint WHERE user.id = :userId AND entryDate = :date", CarbonFootprint.class
                )
                .setParameter("userId", userId)
                .setParameter("date", date)
                .getResultList();
        session.close();
        return entries;
    }

    /**
     * Gets carbon footprint entries by a property value.
     * @param property the field name (e.g., "category", "userName")
     * @param value    the value to search for
     * @return list of matching entries
     */
    public List<CarbonFootprint> getByPropertyEqual(String property, String value) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<CarbonFootprint> query = criteriaBuilder.createQuery(CarbonFootprint.class);
        Root<CarbonFootprint> root = query.from(CarbonFootprint.class);
        Predicate predicate = criteriaBuilder.equal(root.get(property), value);
        query.select(root).where(predicate);
        List<CarbonFootprint> entries = session.createQuery(query).getResultList();
        session.close();
        return entries;
    }


    /**
     * Gets carbon footprint entries by date range.
     *
     * @param startDate the start date
     * @param endDate   the end date
     * @return the by date range
     */
    public List<CarbonFootprint> getByDateRange(LocalDate startDate, LocalDate endDate) {

        Session session = sessionFactory.openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<CarbonFootprint> query = criteriaBuilder.createQuery(CarbonFootprint.class);
        Root<CarbonFootprint> root = query.from(CarbonFootprint.class);
        query.select(root).where(criteriaBuilder.between(root.get("entryDate"), startDate, endDate));
        List<CarbonFootprint> entries = session.createQuery(query).getResultList();
        session.close();
        return entries;


    }
}
