package ir.nas.util;

import java.util.List;
import java.util.function.Function;

import org.glassfish.jaxb.core.v2.model.core.ID;

import ir.nas.exception.db.DBConnectionException;
import ir.nas.model.BaseModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.TypedQuery;

public final class HibernateUtil
{
    private static EntityManagerFactory emf;
    private static final String PERSISTENCE_UNIT_NAME_STRING = "postgresql-unit";

    private HibernateUtil()
    {}

    static {
        if (emf == null)
            emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME_STRING);
    }

    public synchronized static final <T> T startWithTx(final Function<EntityManager, T> function)
    {
        return new HibernateUtil().returnWithTX(function);
    }

    public synchronized static final <T extends BaseModel<ID>, ID extends Number> T startFind(
            final Class<T> clazz,
            final ID id)
    {
        return new HibernateUtil().returnObject(clazz, id);
    }

    public synchronized static final <T extends BaseModel<ID>, ID extends Number> List<T> startWithTList(
            final Class<T> clazz)
    {
        return new HibernateUtil().returnList(clazz);
    }

    public synchronized static final <T extends BaseModel<ID>, ID extends Number> T startWithQuery(final Function<EntityManager, T> function)
    {
        return new HibernateUtil().returnWithQuery(function);
    }

    private synchronized static final EntityManager getEntityManager()
    {
        return emf.createEntityManager();
    }

    private synchronized final <T> T returnWithTX(final Function<EntityManager, T> function)
    {
        final EntityManager em = getEntityManager();
        final EntityTransaction tx = em.getTransaction();

        try (em) {
            if (!tx.isActive())
                tx.begin();

            T obj = function.apply(em);

            tx.commit();

            return obj;
        } catch (PersistenceException e) {

            if (tx.isActive())
                tx.rollback();

            throw new DBConnectionException("HibernateUtil Class Error [returnWithTX()]: "
                    .concat(e.getMessage()));
        }
    }

    private synchronized final <T extends BaseModel<ID>, ID extends Number> T returnObject(
            final Class<T> clazz,
            final ID id)
    {
        try (final EntityManager em = getEntityManager()) {

            return em.find(clazz, id);

        } catch (PersistenceException e) {
            throw new DBConnectionException("HibernateUtil Class Error [returnObject()]: "
                    .concat(e.getMessage()));
        }
    }

    private synchronized final <T extends BaseModel<ID>, ID extends Number> List<T> returnList(final Class<T> clazz)
    {
        final String FIND_ALL_QUERY_STRING = "FROM ".concat(clazz.getSimpleName());

        try (final EntityManager em = getEntityManager()) {

            TypedQuery<T> typedQuery = em.createQuery(FIND_ALL_QUERY_STRING, clazz);
            return typedQuery.getResultList();

        } catch (PersistenceException e) {
            throw new DBConnectionException("HibernateUtil Class Error [returnList()]: "
                    .concat(e.getMessage()));
        }
    }

    private synchronized final <T extends BaseModel<ID>, ID extends Number> T returnWithQuery(final Function<EntityManager, T> function)
    {
        try (final EntityManager em = getEntityManager()) {
            return function.apply(em);
        } catch (PersistenceException e) {
            throw new DBConnectionException("HibernateUtil Class Error [returnList()]: "
                    .concat(e.getMessage()));
        }
    }
}
