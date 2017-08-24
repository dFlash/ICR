package com.mg.icr.logic;

import com.mg.icr.model.dto.SkillTypeDto;

import java.util.List;

public interface SkillTypeLogic {
    List<SkillTypeDto> findAll();
    SkillTypeDto findById(Integer skillTypeId);
    void add(SkillTypeDto skillTypeDto);
    void update(SkillTypeDto skillTypeDto);
    void delete(Integer skillTypeDto);
}
