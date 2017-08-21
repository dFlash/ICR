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
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
@Transactional
public class SkillTypeDaoImpl implements SkillTypeDao{

    private static String SKILL_TYPE_ID = "id";
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<SkillType> findAll() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<SkillType> criteriaQuery = criteriaBuilder.createQuery(SkillType.class);
        Root<SkillType> rootEntry = criteriaQuery.from(SkillType.class);
        CriteriaQuery<SkillType> all = criteriaQuery.select(rootEntry);
        all = all.orderBy(criteriaBuilder.asc(rootEntry.get(SKILL_TYPE_ID)));
        TypedQuery<SkillType> allQuery = entityManager.createQuery(all);
        return allQuery.getResultList();
    }

    @Override
    public SkillType findSkillTypeById(Integer id) {
       return entityManager.find(SkillType.class, id);
    }

}
