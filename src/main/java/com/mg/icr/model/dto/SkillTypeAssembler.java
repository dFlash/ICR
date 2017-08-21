package com.mg.icr.model.dto;

import com.mg.icr.model.SkillType;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SkillTypeAssembler {
    public static List<SkillTypeDto> transferToDTOList(List<SkillType> objects){
        List<SkillTypeDto> skillTypeDtos = objects.stream()
                .map(SkillTypeDto::new)
                .collect(Collectors.toList());
        return skillTypeDtos;
    }

}
