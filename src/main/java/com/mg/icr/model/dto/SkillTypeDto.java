package com.mg.icr.model.dto;

import com.mg.icr.model.SkillType;
import lombok.Data;

@Data
public class SkillTypeDto {

    private String typeName;
    private Integer id;

    public SkillTypeDto(SkillType skillType) {
        this.id = skillType.getId();
        this.typeName = skillType.getTypeName();
    }

    public SkillTypeDto() {
    }

}
