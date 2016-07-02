package dao.impl;

import dao.OsbbDAO;
import model.OsbbEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import util.EntityUtil;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by Roman on 02.07.2016.
 */
public class OsbbDAOImpl implements OsbbDAO {

    private EntityManager em = EntityUtil.getEntityFactoryInstance().createEntityManager();

    @Override
    public <S extends OsbbEntity> S save(S s) {
        em.getTransaction().begin();
        em.persist(s);
        em.getTransaction().commit();
        em.close();
        return s;
    }

    @Override
    public OsbbEntity findOne(Integer integer) {
        return null;
    }

    @Override
    public boolean exists(Integer integer) {
        return false;
    }

    @Override
    public List<OsbbEntity> findAll() {
        return null;
    }

    @Override
    public List<OsbbEntity> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<OsbbEntity> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<OsbbEntity> findAll(Iterable<Integer> iterable) {
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
    public void delete(OsbbEntity osbbEntity) {

    }

    @Override
    public void delete(Iterable<? extends OsbbEntity> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public void flush() {

    }

    @Override
    public void deleteInBatch(Iterable<OsbbEntity> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public OsbbEntity getOne(Integer integer) {
        return null;
    }

    @Override
    public <S extends OsbbEntity> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public <S extends OsbbEntity> List<S> save(Iterable<S> iterable) {
        return null;
    }
}
