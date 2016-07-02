package dao.impl;


import dao.HouseEntityDAO;
import model.HouseEntity;
import util.EntityUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.transaction.TransactionalException;
import java.util.List;

/**
 * Created by nazar.dovhyy on 02.07.2016.
 */
public class HouseEntityDAOimpl implements HouseEntityDAO {

    private EntityManagerFactory entityManagerFactory = EntityUtil.getEntityFactoryInstance("postgres-nado");

    @Override
    public <S extends HouseEntity> S save(S s) {

        EntityManager em = entityManagerFactory.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(s);
            em.getTransaction().commit();
            System.out.println("saved object");

        } catch (TransactionalException e) {
            em.getTransaction().rollback();
            return null;
        } finally {
            EntityUtil.closeEntityManager(em);
        }

        return s;
    }


    @Override
    public List<HouseEntity> findAll() {

        EntityManager em = entityManagerFactory.createEntityManager();

        List<HouseEntity> housesList = em.createQuery("from HouseEntity").getResultList();

        EntityUtil.closeEntityManager(em);

        return housesList;
    }


    @Override
    public void delete(HouseEntity houseEntity) {
        delete(houseEntity.getHouseId());
    }

    @Override
    public void delete(Integer integer) {

        EntityManager em = entityManagerFactory.createEntityManager();

        try {
            em.getTransaction().begin();

            Query query = em.createQuery("from HouseEntity where houseId = :id");
            query.setParameter("id", integer);

            HouseEntity houseEntity = (HouseEntity) query.getSingleResult();
            em.remove(houseEntity);

            em.getTransaction().commit();
            System.out.println("removed object id: "+houseEntity.getHouseId());

        } catch (TransactionalException tx) {
            em.getTransaction().rollback();
            return;

        } finally {
            EntityUtil.closeEntityManager(em);
        }
    }

    @Override
    public HouseEntity update(HouseEntity houseEntity) {

        EntityManager em = entityManagerFactory.createEntityManager();
        try {
            em.getTransaction().begin();

            houseEntity = em.merge(houseEntity);

            em.getTransaction().commit();
            System.out.println("updated object id: "+houseEntity.getHouseId());
        } catch (TransactionalException tx) {
            em.getTransaction().rollback();
            return null;

        } finally {
            EntityUtil.closeEntityManager(em);
        }
        return houseEntity;
    }

    @Override
    public void deleteAll() {

    }


    @Override
    public HouseEntity findBy(String token) {
        return null;
    }

    @Override
    public HouseEntity findById(Integer id) {

        EntityManager em = entityManagerFactory.createEntityManager();

        Query query = em.createQuery("from HouseEntity where houseId = :houseId");
        query.setParameter("houseId", id);

        HouseEntity houseEntity = (HouseEntity) query.getSingleResult();

        EntityUtil.closeEntityManager(em);

        return houseEntity;
    }
}
