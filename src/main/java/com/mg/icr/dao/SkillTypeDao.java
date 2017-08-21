package com.mg.icr.dao;

import com.mg.icr.model.SkillType;
import com.mg.icr.model.dto.SkillTypeDto;

import java.util.List;

public interface SkillTypeDao {
    List<SkillType> findAll();
}
