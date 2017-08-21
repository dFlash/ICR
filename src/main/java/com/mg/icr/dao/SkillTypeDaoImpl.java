package com.mg.icr.dao;

import com.mg.icr.model.SkillType;
import com.mg.icr.model.dto.SkillTypeDto;
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
public class SkillTypeDaoImpl implements SkillTypeDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<SkillType> findAll() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<SkillType> cq = cb.createQuery(SkillType.class);
        Root<SkillType> rootEntry = cq.from(SkillType.class);
        CriteriaQuery<SkillType> all = cq.select(rootEntry);
        all = all.orderBy(cb.asc(rootEntry.get("id")));
        TypedQuery<SkillType> allQuery = entityManager.createQuery(all);
        return allQuery.getResultList();
    }
}
