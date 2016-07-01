package dao.impl;

import util.EntityUtil;
import dao.StaffDAO;
import model.StaffEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by Aska on 01.07.2016.
 */
public class StaffDAOImpl implements StaffDAO {
    private EntityManager em = EntityUtil.getEntityFactoryInstance().createEntityManager();


    @Override
    public List<StaffEntity> findAll() {
        return null;
    }

    @Override
    public List<StaffEntity> findAll(Sort sort) {
        return null;
    }

    @Override
    public List<StaffEntity> findAll(Iterable<Integer> iterable) {
        return null;
    }

    @Override
    public <S extends StaffEntity> List<S> save(Iterable<S> iterable) {
        return null;
    }

    @Override
    public StaffEntity findOne(Integer integer) {
        return null;
    }

    @Override
    public boolean exists(Integer integer) {
        return false;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void delete(Integer integer) {

    }

    @Override
    public void delete(StaffEntity staffEntity) {

    }

    @Override
    public void delete(Iterable<? extends StaffEntity> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends StaffEntity> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<StaffEntity> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public StaffEntity getOne(Integer integer) {
        return null;
    }

    @Override
    public Page<StaffEntity> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public <S extends StaffEntity> S save(S s) {
        em.getTransaction().begin();
        em.persist(s);
        em.getTransaction().commit();
        em.close();
        System.out.println("privet from save");
        return s;
    }
}