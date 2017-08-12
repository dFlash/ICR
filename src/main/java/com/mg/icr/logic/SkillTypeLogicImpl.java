package com.mg.icr.logic;

import com.mg.icr.dao.SkillTypeDao;
import com.mg.icr.model.SkillType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillTypeLogicImpl implements SkillTypeLogic {

    @Autowired
    private SkillTypeDao skillTypeDao;

    @Override
    public List<SkillType> findAll() {
        return skillTypeDao.findAll();
    }
}
