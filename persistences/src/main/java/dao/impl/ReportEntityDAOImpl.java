package dao.impl;


import dao.ReportEntityDAO;
import model.ReportEntity;
import util.EntityUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.transaction.TransactionalException;
import java.util.List;

/**
 * Created by nazar.dovhyy on 02.07.2016.
 */
public class ReportEntityDAOImpl implements ReportEntityDAO {

    EntityManagerFactory entityManagerFactory = EntityUtil.getEntityFactoryInstance("postgres-nado");

    @Override
    public <S extends ReportEntity> S save(S reportEntity) {
        EntityManager em = entityManagerFactory.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(reportEntity);
            em.getTransaction().commit();
            System.out.println("saved object");
        } catch (TransactionalException e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            return null;
        } finally {
            EntityUtil.closeEntityManager(em);
        }
        return reportEntity;
    }

    @Override
    public ReportEntity update(ReportEntity reportEntity) {

        EntityManager em = entityManagerFactory.createEntityManager();

        try {
            em.getTransaction().begin();
            reportEntity = em.merge(reportEntity);
            em.getTransaction().commit();
            System.out.println("updated object id: " + reportEntity.getReportId());
        } catch (TransactionalException tx) {
            em.getTransaction().rollback();
            return null;
        } finally {
            EntityUtil.closeEntityManager(em);
        }

        return reportEntity;
    }

    @Override
    public ReportEntity findBy(String token) {
        throw new UnsupportedOperationException("this function is not yet implemented");
    }

    @Override
    public ReportEntity findById(Integer id) {

        EntityManager em = entityManagerFactory.createEntityManager();
        Query query = em.createQuery("from ReportEntity where reportId =:reportId");
        query.setParameter("reportId", id);
        ReportEntity reportEntity = (ReportEntity) query.getSingleResult();
        System.out.println("found object with id: " + reportEntity.getReportId());
        EntityUtil.closeEntityManager(em);
        return reportEntity;
    }


    @Override
    public void delete(Integer id) {
        EntityManager em = entityManagerFactory.createEntityManager();

        try {
            em.getTransaction().begin();
            Query query = em.createQuery("from ReportEntity where  reportId = :id");
            query.setParameter("id", id);
            ReportEntity reportEntity = (ReportEntity) query.getSingleResult();
            em.remove(reportEntity);
            em.getTransaction().commit();
            System.out.println("removed object id: " + reportEntity.getReportId());
        } catch (TransactionalException tx) {
            em.getTransaction().rollback();
            return;
        } finally {
            EntityUtil.closeEntityManager(em);
        }
    }

    @Override
    public void delete(ReportEntity reportEntity) {
        delete(reportEntity.getReportId());
    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<ReportEntity> findAll() {
        EntityManager em = entityManagerFactory.createEntityManager();
        List<ReportEntity> reportEntities = em.createQuery("from ReportEntity").getResultList();
        EntityUtil.closeEntityManager(em);
        return reportEntities;
    }


}
