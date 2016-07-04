package dao.impl;

import dao.VoteDAO;
import model.VoteEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

/**
 * Created by Roman on 02.07.2016.
 */
public class VoteDAOImpl implements VoteDAO {
    @Override
    public <S extends VoteEntity> S save(S s) {
        return null;
    }

    @Override
    public VoteEntity findOne(Integer integer) {
        return null;
    }

    @Override
    public boolean exists(Integer integer) {
        return false;
    }

    @Override
    public List<VoteEntity> findAll() {
        return null;
    }

    @Override
    public List<VoteEntity> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<VoteEntity> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<VoteEntity> findAll(Iterable<Integer> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void delete(Integer integer) {

    }

    @Override
    public void delete(VoteEntity voteEntity) {

    }

    @Override
    public void delete(Iterable<? extends VoteEntity> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public void flush() {

    }

    @Override
    public void deleteInBatch(Iterable<VoteEntity> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public VoteEntity getOne(Integer integer) {
        return null;
    }

    @Override
    public <S extends VoteEntity> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public <S extends VoteEntity> List<S> save(Iterable<S> iterable) {
        return null;
    }
}
