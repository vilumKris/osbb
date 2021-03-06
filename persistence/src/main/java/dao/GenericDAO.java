package dao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.List;

/**
 * Created by nazar.dovhyy on 02.07.2016.
 */
public interface GenericDAO<T, K extends Serializable> extends JpaRepository<T, K> {

    long DEFAULT_COUNT_VAL = -1;

    boolean DEFAULT_EXISTS_VAL = false;

    @Override
    <S extends T> S save(S s);

    /*list of optional methods */

    default T update(T t) {
        throw new UnsupportedOperationException();
    }

    @Override
    default void delete(T t) {
        throw new UnsupportedOperationException();
    }

    @Override
    default T findOne(K k) {
        throw new UnsupportedOperationException();
    }

    @Override
    default List<T> findAll() {
        throw new UnsupportedOperationException();
    }

    @Override
    default void delete(K k) {
        throw new UnsupportedOperationException();
    }
    @Override
    default void deleteAll() {
        throw new UnsupportedOperationException();
    }


    default T findBy(String token){
        throw new UnsupportedOperationException();
    }

    default T findById(K id){
        throw new UnsupportedOperationException();
    }

    @Override
    default List<T> findAll(Sort sort) {
        throw new UnsupportedOperationException();
    }

    @Override
    default List<T> findAll(Iterable<K> iterable) {
        throw new UnsupportedOperationException();
    }

    @Override
    default <S extends T> List<S> save(Iterable<S> iterable) {
        throw new UnsupportedOperationException();
    }

    @Override
    default void flush() {
        throw new UnsupportedOperationException();
    }

    @Override
    default <S extends T> S saveAndFlush(S s) {
        throw new UnsupportedOperationException();
    }

    @Override
    default void deleteInBatch(Iterable<T> iterable) {

    }

    @Override
    default void deleteAllInBatch() {
        throw new UnsupportedOperationException();
    }

    @Override
    default T getOne(K k) {
        throw new UnsupportedOperationException();
    }

    @Override
    default Page<T> findAll(Pageable pageable) {
        throw new UnsupportedOperationException();
    }



    @Override
    default boolean exists(K k) {
        return DEFAULT_EXISTS_VAL;
    }

    @Override
    default long count() {
        return DEFAULT_COUNT_VAL;
    }


    @Override
    default void delete(Iterable<? extends T> iterable) {
        throw new UnsupportedOperationException();
    }

}
