package dao.impl;

import dao.MessageDAO;
import model.MessageEntity;
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
public class MessageDAOImpl implements MessageDAO{
    EntityManagerFactory entityManagerFactory = EntityUtil.getEntityFactoryInstance("postgres-nado");

    public EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

    @Override
    public <S extends MessageEntity> S save(S messageEntity) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(messageEntity);
            em.getTransaction().commit();
            System.out.println("Saved object");
        } catch (TransactionalException e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            return null;
        } finally {
            EntityUtil.closeEntityManager(em);
        }
        return messageEntity;
    }

    @Override
    public MessageEntity update(MessageEntity messageEntity) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            messageEntity = em.merge(messageEntity);
            em.getTransaction().commit();
            System.out.println("Updated object id: " + messageEntity.getMessageId());
        } catch (TransactionalException tx) {
            em.getTransaction().rollback();
            return null;
        } finally {
            EntityUtil.closeEntityManager(em);
        }

        return messageEntity;
    }

    @Override
    public MessageEntity findBy(String token) {
        return null;
    }

    @Override
    public MessageEntity findById(Integer id) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("from MessageEntity where messageId =:messageId");
        query.setParameter("messageId", id);
        MessageEntity messageEntity = (MessageEntity) query.getSingleResult();
        System.out.println("found object with id: " + messageEntity.getMessageId());
        EntityUtil.closeEntityManager(em);
        return messageEntity;
    }

    @Override
    public void delete(Integer id) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Query query = em.createQuery("from MessageEntity where  messageId = :id")
                    .setParameter("id", id);
            MessageEntity messageEntity = (MessageEntity) query.getSingleResult();
            em.remove(messageEntity);
            em.getTransaction().commit();
            System.out.println("removed object id: " + messageEntity.getMessageId());
        } catch (TransactionalException tx) {
            em.getTransaction().rollback();
            return;
        } finally {
            EntityUtil.closeEntityManager(em);
        }
    }

    @Override
    public void delete(MessageEntity messageEntity) {
        delete(messageEntity.getMessageId());
    }

    @Override
    public void deleteAll() {
        EntityManager em = getEntityManager();
        List<MessageEntity> messageEntities = em.createQuery("from MessageEntity").getResultList();
        Iterator<MessageEntity> iter = messageEntities.iterator();
        while (iter.hasNext()){
            delete(iter.next());
            iter.next();
        }
        EntityUtil.closeEntityManager(em);
    }

    @Override
    public List<MessageEntity> findAll() {
        EntityManager em = getEntityManager();
        List<MessageEntity> messageEntities = em.createQuery("from MessageEntity").getResultList();
        EntityUtil.closeEntityManager(em);
        return messageEntities;
    }
}


