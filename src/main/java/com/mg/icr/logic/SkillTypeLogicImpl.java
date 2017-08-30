package com.mg.icr.logic;

import com.mg.icr.dao.SkillTypeDao;
import com.mg.icr.model.SkillType;
import com.mg.icr.model.dto.SkillTypeDto;
import com.mg.icr.model.dto.SkillTypeAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SkillTypeLogicImpl implements SkillTypeLogic {

    @Autowired
    private SkillTypeDao skillTypeDao;

    @Override
    public List<SkillTypeDto> findAll() {
        return SkillTypeAssembler.toDTOList(skillTypeDao.findAll());
    }

    @Override
    public SkillTypeDto find(Integer skillTypeId) {
        return SkillTypeAssembler.toDTO(skillTypeDao.find(skillTypeId));
    }

    @Override
    public void add(SkillTypeDto skillTypeDto) {
        SkillType skillType = SkillTypeAssembler.toEntity(skillTypeDto);
        skillTypeDao.add(skillType);
    }

    @Override
    public void update(SkillTypeDto skillTypeDto) {
        Optional<SkillType> skillTypeOptional = Optional.ofNullable(
                skillTypeDao.find(skillTypeDto.getId()));
        skillTypeOptional.ifPresent(skillType -> {
            skillType.setTypeName(skillTypeDto.getTypeName());
            skillTypeDao.update(skillType);
        });
    }

    @Override
    public void delete(Integer id) {
        Optional<SkillType> skillTypeOptional = Optional.ofNullable(
                skillTypeDao.find(id));
        skillTypeOptional.ifPresent(skillType -> skillTypeDao.delete(skillType));
    }
}
