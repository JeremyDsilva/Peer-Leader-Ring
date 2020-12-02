package repository;

import response.Response;

public interface Repository<T, ID> {

    Response<ID> create(T entity);

    Response<T> read(ID id);

    Response<T> update(T entity);

    Response<T> delete(T entity);

}
