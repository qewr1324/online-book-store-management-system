package ir.nas.repository;

import java.util.List;
import java.util.Optional;

import ir.nas.model.BaseModel;

public interface Repository<T extends BaseModel<ID>, ID extends Number>
{
    T create(T t);

    Optional<T> read(ID id);

    boolean update(T t);

    T delete(ID id);

    List<T> findAll();
}
