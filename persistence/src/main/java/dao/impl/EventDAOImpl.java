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
    public EventEntity update(EventEntity eventEntity) {
        return null;
    }

    @Override
    public EventEntity findBy(String token) {
        return null;
    }

    @Override
    public EventEntity findById(Integer id) {
        return null;
    }

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
        EventEntity ee = em.find(EventEntity.class, integer);
        em.getTransaction().commit();
        System.out.println("Event №" + ee.getIdEvent() + ": " + ee.getName()
                + "\nAuthor: " + ee.getAuthor() + "\nDescription: " +ee.getDescription());
        return ee;
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
    public boolean exists(Integer integer) {
        em.getTransaction().begin();
        EventEntity event = em.find(EventEntity.class, integer);
        em.getTransaction().commit();
        System.out.print("Event №" + event.getIdEvent() + ": " + event.getName());
        if (event == null) {
            System.out.println(" doesn`t exists.");
            return false;
        }
        else {
            System.out.println(" exists.");
            return true;
        }
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
        em.getTransaction().begin();
        long result = (long) em.createQuery("SELECT count(*) FROM EventEntity").getSingleResult();
        em.getTransaction().commit();
        System.out.println("OSBB has " + result + " events.");
        return result;
    }

    @Override
    public void delete(Integer integer) {
//        EventEntity event = em.find(EventEntity.class, integer);
//        EventEntity event = em.getReference(EventEntity.class, integer);
        EventEntity event = em.createQuery("select e from EventEntity as e where e.idEvent = :integer",
                EventEntity.class).setParameter(integer, findById(integer)).getSingleResult();
        System.out.print("Event №" + event.getIdEvent() + ": " + event.getName() + " removed.");
        if (event != null) {
            em.getTransaction().begin();
            em.remove(event);
            em.getTransaction().commit();
        }
    }

    @Override
    public void delete(EventEntity eventEntity) {
        em.remove(eventEntity);
        System.out.print("Event №" + eventEntity.getIdEvent() + ": " + eventEntity.getName() + " removed.");
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
        em.getTransaction().begin();
        EventEntity ee = em.find(EventEntity.class, integer);
        em.getTransaction().commit();
        System.out.println("Event №" + ee.getIdEvent() + ": " + ee.getName()
                + "\nAuthor: " + ee.getAuthor() + "\nDescription: " +ee.getDescription());
        return ee;
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
