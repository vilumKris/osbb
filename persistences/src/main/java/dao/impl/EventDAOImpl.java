package dao.impl;

import dao.EventDAO;
import model.EventEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import util.EntityUtil;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by nataliia on 02.07.16.
 */
public class EventDAOImpl implements EventDAO {

    private EntityManager em = EntityUtil.getEntityFactoryInstance().createEntityManager();

    @Override
    public <S extends EventEntity> S save(S s) {
        em.getTransaction().begin();
        em.persist(s);
        em.getTransaction().commit();
        return s;
    }

    @Override
    public EventEntity findOne(Integer integer) {
        em.getTransaction().begin();
        EventEntity result = em.createQuery("from EventEntity E where E.idEvent =" + integer, EventEntity.class).getSingleResult();
        EventEntity ee = result;
        System.out.println("Event №" + ee.getIdEvent() + ": " + ee.getName()
                + "\nAuthor: " + ee.getAuthor() + "\nDescription: " +ee.getDescription());
        return result;
    }

    @Override
    public boolean exists(Integer integer) {
        return false;
    }

    @Override
    public List<EventEntity> findAll() {
        em.getTransaction().begin();
        List<EventEntity> result = em.createQuery("from EventEntity", EventEntity.class).getResultList();
        for (EventEntity event : result) {
            System.out.println("Event №" + event.getIdEvent() + ": " + event.getName()
                    + "\nAuthor: " + event.getAuthor() + "\nDescription: " +event.getDescription());
        }
        em.getTransaction().commit();
        em.close();
        return result;
    }

    @Override
    public List<EventEntity> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<EventEntity> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<EventEntity> findAll(Iterable<Integer> iterable) {
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
    public void delete(EventEntity eventEntity) {

    }

    @Override
    public void delete(Iterable<? extends EventEntity> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public void flush() {

    }

    @Override
    public void deleteInBatch(Iterable<EventEntity> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public EventEntity getOne(Integer integer) {
        return null;
    }

    @Override
    public <S extends EventEntity> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public <S extends EventEntity> List<S> save(Iterable<S> iterable) {
        return null;
    }
}
