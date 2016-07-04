package dao.impl;

import dao.RoleDAO;
import model.RoleEntity;
import util.EntityUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Oleg on 03.07.2016.
 */
public class RoleDAOImpl implements RoleDAO {
    private EntityManager em ;

    @Override
    public <S extends RoleEntity> S save(S s) {
        em= EntityUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(s);
        em.getTransaction().commit();
        em.close();
return s;
    }

    @Override
    public RoleEntity update(RoleEntity roleEntity) {
        em=EntityUtil.getEntityManager();
        em.getTransaction().begin();
        roleEntity=em.merge(roleEntity);
        em.getTransaction().commit();
        em.close();
        System.out.println("role was updated");
        return roleEntity;
    }

    @Override
    public void delete(RoleEntity roleEntity) {
    delete(roleEntity.getIdRole());
    }

    @Override
    public void delete(Integer integer){
        em=EntityUtil.getEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("from RoleEntity where role_id= :integer ");
        query.setParameter("role_id",integer);
        RoleEntity roleEntity = (RoleEntity) query.getSingleResult();
        em.remove(roleEntity);
        em.getTransaction().commit();
        System.out.println("object was removed");
    }
    @Override
    public List<RoleEntity> findAll() {
        em=EntityUtil.getEntityManager();
        List<RoleEntity> roleEntityList = em.createQuery("from role").getResultList();
        EntityUtil.closeEntityManager(em);
        return roleEntityList;
    }


}
