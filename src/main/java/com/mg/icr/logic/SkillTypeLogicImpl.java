package com.mg.icr.logic;

import com.mg.icr.dao.SkillTypeDao;
import com.mg.icr.model.SkillType;
import com.mg.icr.model.dto.SkillTypeDto;
import com.mg.icr.model.dto.SkillTypeAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillTypeLogicImpl implements SkillTypeLogic {

    @Autowired
    private SkillTypeDao skillTypeDao;

    @Override
    public List<SkillTypeDto> findAll() {
        List<SkillType> skillTypeList = skillTypeDao.findAll();
        return SkillTypeAssembler.transferToDTOList(skillTypeList);
    }
}
