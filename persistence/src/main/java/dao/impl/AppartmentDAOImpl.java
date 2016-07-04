package dao.impl;

import dao.AppartmentDAO;
import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;
import model.AppartamentEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


import util.EntityUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.TransactionalException;
import java.util.List;

/**
 * Created by Oleg on 01.07.2016.
 */
public class AppartmentDAOImpl implements AppartmentDAO {


  private  EntityManager em ;

    @Override
     public <S extends AppartamentEntity> S save(S s) {
        em = EntityUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(s);
        em.getTransaction().commit();
        EntityUtil.closeEntityManager(em);
        return s;
    }

    @Override
    public AppartamentEntity findOne(Integer integer) {
        em.getTransaction().begin();
       AppartamentEntity ae = em.find(AppartamentEntity.class, integer);
        em.getTransaction().commit();
        em.close();
        return ae;
    }

    @Override
    public boolean exists(Integer integer) {
       em= EntityUtil.getEntityManager();
        em.getTransaction().begin();
        AppartamentEntity appartamentEntity = em.find(AppartamentEntity.class, integer);
        em.getTransaction().commit();
        EntityUtil.closeEntityManager(em);
        if (appartamentEntity== null){
            System.out.println("object  not exist");
            return false;
        }else{
            System.out.println("object exist");
            return  true;
        }
    }

    @Override
    public List<AppartamentEntity> findAll() {
        em= EntityUtil.getEntityManager();
        List<AppartamentEntity> appList =
                em.createQuery("from AppartamentEntity",AppartamentEntity.class)
                .getResultList();
        EntityUtil.closeEntityManager(em);

        return appList;
    }

    @Override
    public List<AppartamentEntity> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<AppartamentEntity> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<AppartamentEntity> findAll(Iterable<Integer> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void delete(Integer integer) {
        EntityManager em = EntityUtil.getEntityManager();

        try {
            em.getTransaction().begin();

            Query query = em.createQuery("from AppartamentEntity where appartament_id = :id");
            query.setParameter("id", integer);

            AppartamentEntity appartamentEntity = (AppartamentEntity) query.getSingleResult();
            em.remove(appartamentEntity);

            em.getTransaction().commit();
            System.out.println("removed object id: "+appartamentEntity.getAppartamentId());

        } catch (TransactionalException tx) {
            em.getTransaction().rollback();
            return;

        } finally {
            EntityUtil.closeEntityManager(em);
        }
    }

    @Override
    public void delete(AppartamentEntity appartamentEntity) {
        delete(appartamentEntity.getAppartamentId());
    }

    @Override
    public void delete(Iterable<? extends AppartamentEntity> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public AppartamentEntity update(AppartamentEntity appartamentEntity){
        em = EntityUtil.getEntityManager();
        try{
            em.getTransaction().begin();
            appartamentEntity=em.merge(appartamentEntity);
            em.getTransaction().commit();
            System.out.println("updated object");
        } catch (TransactionalException ex){
            em.getTransaction().rollback();
            return null;
        }finally {
            EntityUtil.closeEntityManager(em);
        }
        return  appartamentEntity;
    }
    @Override
    public void flush() {

    }

    @Override
    public void deleteInBatch(Iterable<AppartamentEntity> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public AppartamentEntity getOne(Integer integer) {
        return null;
    }

    @Override
    public <S extends AppartamentEntity> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public <S extends AppartamentEntity> List<S> save(Iterable<S> iterable) {
        return null;
    }
}
