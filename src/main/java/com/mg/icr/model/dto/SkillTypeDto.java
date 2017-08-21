package com.mg.icr.model.dto;

import com.mg.icr.model.SkillType;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class SkillTypeDto {

    @Setter
    @Getter
    private String typeName;

    @Setter
    @Getter
    private Integer id;

    public SkillTypeDto(SkillType skillType) {
        this.id = skillType.getId();
        this.typeName = skillType.getTypeName();
    }

}
