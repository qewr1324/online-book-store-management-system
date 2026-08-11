package ir.nas.repository;

import java.util.List;
import java.util.Optional;

import ir.nas.model.base.BaseModel;

/**
 * Repository
 * 
 * <p>An interface for basic crud operations</p>
 * 
 * @param <T>
 * @param <ID>
 */

public interface Repository<T extends BaseModel<ID>, ID extends Number>
{
    T create(T t);

    Optional<T> findById(ID id);

    T update(T t);

    T delete(ID id);

    List<T> findAll();
}
