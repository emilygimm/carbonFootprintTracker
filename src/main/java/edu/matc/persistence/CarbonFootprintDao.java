package edu.matc.persistence;

import edu.matc.entity.CarbonFootprintEntry;
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
    public CarbonFootprintEntry getById(int id) {
        Session session = sessionFactory.openSession();
        CarbonFootprintEntry entry = session.get(CarbonFootprintEntry.class, id);
        session.close();
        return entry;
    }

    /**
     * Inserts a new carbon footprint entry.
     *
     * @param entry the entry
     * @return the int
     */
    public int insert(CarbonFootprintEntry entry) {
        int id;
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
    public void update(CarbonFootprintEntry entry) {
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
    public void delete(CarbonFootprintEntry entry) {
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
    public List<CarbonFootprintEntry> getAll() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<CarbonFootprintEntry> query = criteriaBuilder.createQuery(CarbonFootprintEntry.class);
        Root<CarbonFootprintEntry> root = query.from(CarbonFootprintEntry.class);
        query.select(root);
        List<CarbonFootprintEntry> entries = session.createQuery(query).getResultList();
        session.close();
        return entries;
    }

    public List<CarbonFootprintEntry> getEntriesByUserIdAndDate(int userId, LocalDate date) {
        Session session = sessionFactory.openSession();
        List<CarbonFootprintEntry> entries = session.createQuery(
                        "FROM CarbonFootprintEntry WHERE user.id = :userId AND entryDate = :date", CarbonFootprintEntry.class
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
    public List<CarbonFootprintEntry> getByPropertyEqual(String property, String value) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<CarbonFootprintEntry> query = criteriaBuilder.createQuery(CarbonFootprintEntry.class);
        Root<CarbonFootprintEntry> root = query.from(CarbonFootprintEntry.class);
        Predicate predicate = criteriaBuilder.equal(root.get(property), value);
        query.select(root).where(predicate);
        List<CarbonFootprintEntry> entries = session.createQuery(query).getResultList();
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
    public List<CarbonFootprintEntry> getByDateRange(LocalDate startDate, LocalDate endDate) {

        Session session = sessionFactory.openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<CarbonFootprintEntry> query = criteriaBuilder.createQuery(CarbonFootprintEntry.class);
        Root<CarbonFootprintEntry> root = query.from(CarbonFootprintEntry.class);
        query.select(root).where(criteriaBuilder.between(root.get("entryDate"), startDate, endDate));
        List<CarbonFootprintEntry> entries = session.createQuery(query).getResultList();
        session.close();
        return entries;


    }
}
