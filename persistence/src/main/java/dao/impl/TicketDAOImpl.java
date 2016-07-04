package dao.impl;

import dao.TicketDAO;
import model.MessageEntity;
import model.TicketEntity;
import util.EntityUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.transaction.TransactionalException;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Администратор on 03.07.2016.
 */
public class TicketDAOImpl implements TicketDAO {
    EntityManagerFactory entityManagerFactory = EntityUtil.getEntityFactoryInstance("postgres-nado");


    public EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }


    @Override
    public TicketEntity update(TicketEntity ticketEntity) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            ticketEntity = em.merge(ticketEntity);
            em.getTransaction().commit();
            System.out.println("Updated object id: " + ticketEntity.getTicketId());
        } catch (TransactionalException tx) {
            em.getTransaction().rollback();
            return null;
        } finally {
            EntityUtil.closeEntityManager(em);
        }

        return ticketEntity;
    }

    @Override
    public TicketEntity findBy(String token) {
        return null;
    }

    @Override
    public TicketEntity findById(Integer id) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("from MessageEntity where messageId =:messageId");
        query.setParameter("messageId", id);
        TicketEntity ticketEntity = (TicketEntity) query.getSingleResult();
        System.out.println("found object with id: " + ticketEntity.getTicketId());
        EntityUtil.closeEntityManager(em);
        return ticketEntity;
    }

    @Override
    public <S extends TicketEntity> S save(S ticketEntity) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(ticketEntity);
            em.getTransaction().commit();
            System.out.println("Saved object");
        } catch (TransactionalException e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            return null;
        } finally {
            EntityUtil.closeEntityManager(em);
        }
        return ticketEntity;
    }

    @Override
    public void delete(Integer id) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Query query = em.createQuery("from MessageEntity where  messageId = :id")
                    .setParameter("id", id);
            TicketEntity ticketEntity = (TicketEntity) query.getSingleResult();
            em.remove(ticketEntity);
            em.getTransaction().commit();
            System.out.println("Removed object id: " + ticketEntity.getTicketId());
        } catch (TransactionalException tx) {
            em.getTransaction().rollback();
            return;
        } finally {
            EntityUtil.closeEntityManager(em);
        }
    }

    @Override
    public void delete(TicketEntity ticketEntity) {
        delete(ticketEntity.getTicketId());
    }

    @Override
    public void deleteAll() {
        EntityManager em = getEntityManager();
        List<TicketEntity> ticketEntities = em.createQuery("from MessageEntity").getResultList();
        Iterator<TicketEntity> iter = ticketEntities.iterator();
        while (iter.hasNext()){
            delete(iter.next());
            iter.next();
        }
        EntityUtil.closeEntityManager(em);
    }

    @Override
    public List<TicketEntity> findAll() {
        EntityManager em = getEntityManager();
        List<TicketEntity> ticketEntity = em.createQuery("from TicketEntity").getResultList();
        EntityUtil.closeEntityManager(em);
        return ticketEntity;
    }
}
