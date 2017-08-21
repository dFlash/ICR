package com.mg.icr.dao;

import com.mg.icr.model.BonusType;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
@Transactional
public class BonusTypeDaoImpl implements BonusTypeDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<BonusType> findAll() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<BonusType> cq = cb.createQuery(BonusType.class);
        Root<BonusType> rootEntry = cq.from(BonusType.class);
        CriteriaQuery<BonusType> all = cq.select(rootEntry);
        all = all.orderBy(cb.asc(rootEntry.get("id")));
        TypedQuery<BonusType> allQuery = entityManager.createQuery(all);
        return allQuery.getResultList();
    }

    @Override
    public BonusType find(Integer id) {
        return entityManager.find(BonusType.class, id);
    }

    @Override
    public void save(BonusType bonusType) {
        entityManager.persist(bonusType);
    }
}
