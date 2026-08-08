package ir.nas.util;

import java.util.function.Function;

import ir.nas.exception.db.DBConnectionException;
import ir.nas.model.BaseModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceException;

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

    public synchronized static final HibernateUtil of()
    {
        return new HibernateUtil();
    }

    private synchronized static final EntityManager getEntityManager()
    {
        return emf.createEntityManager();
    }

    public synchronized final <T> T returnWithTX(final Function<EntityManager, T> function)
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

    public synchronized final <T extends BaseModel<ID>, ID extends Number> T returnObject(
            final ID id,
            final Class<T> clazz)
    {
        try (final EntityManager em = getEntityManager()) {

            return em.find(clazz, id);

        } catch (PersistenceException e) {
            throw new DBConnectionException("HibernateUtil Class Error [returnObject()]: "
                    .concat(e.getMessage()));
        }
    }
}
