package ir.nas.repository;

import java.util.List;
import java.util.Optional;

import ir.nas.exception.repository.ModelNotFoundException;
import ir.nas.model.base.BaseModel;
import ir.nas.util.HibernateUtil;

public abstract class RepositoryImpl<T extends BaseModel<ID>, ID extends Number> implements Repository<T, ID>
{
    private final Class<T> clazz;

    public RepositoryImpl(final Class<T> clazz)
    {
        this.clazz = clazz;
    }

    @Override
    public T create(T t)
    {
        return HibernateUtil.startWithTx(em -> {
            // !AI - SAVE
            if (t.getId() == null)
                em.persist(t);
            else
                em.merge(t);

            return t;
        });
    }

    @Override
    public T delete(ID id)
    {
        return HibernateUtil.startWithTx(em -> {
            T findT = em.find(clazz, id);

            if (findT == null)
                throw new ModelNotFoundException("RepositoryImpl Class Error [delete()]: %s Model Not Found!"
                        .formatted(clazz.getSimpleName()));

            em.remove(findT);

            return findT;
        });
    }

    @Override
    public List<T> findAll()
    {
        return HibernateUtil.startWithTList(clazz);
    }

    @Override
    public Optional<T> findById(ID id)
    {
        return Optional.ofNullable(HibernateUtil.startFind(clazz, id));
    }

    @Override
    public T update(T t)
    {
        return HibernateUtil.startWithTx(em -> {
            T findedT = em.find(clazz, t.getId());

            if (findedT == null)
                throw new ModelNotFoundException("RepositoryImpl Class Error [update()]: %s Model Not Found!"
                        .formatted(clazz.getSimpleName()));

            T setModel = this.updateAllSetter(findedT, t);

            return setModel;

            // return em.merge(setModel);
        });
    }

    public abstract T updateAllSetter(final T src, final T target);
}
