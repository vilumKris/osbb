package dao.impl;

import dao.OsbbDAO;
import model.OsbbEntity;
import util.EntityUtil;

import javax.persistence.EntityManager;

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

}
