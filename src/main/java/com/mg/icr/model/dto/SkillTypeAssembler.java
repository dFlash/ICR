package com.mg.icr.model.dto;

import com.mg.icr.model.SkillType;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SkillTypeAssembler {
    public static List<SkillTypeDto> toDTOList(List<SkillType> objects){
        List<SkillTypeDto> skillTypeDtos = objects.stream()
                .map(SkillTypeDto::new)
                .collect(Collectors.toList());
        return skillTypeDtos;
    }

    public static SkillTypeDto toDTO(SkillType skillType){
        return skillType == null ? null : new SkillTypeDto(skillType);
    }

    public static SkillType toEntity(SkillTypeDto bonusTypeDto) {
        return SkillType.builder().typeName(bonusTypeDto.getTypeName()).build();
    }

}
