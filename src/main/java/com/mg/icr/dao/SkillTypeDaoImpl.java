package com.mg.icr.dao;

import com.mg.icr.model.SkillType;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class SkillTypeDaoImpl implements SkillTypeDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<SkillType> findAll() {
        return sessionFactory.getCurrentSession()
                .createCriteria(SkillType.class)
                .addOrder(Order.asc("id"))
                .list();
    }
}
