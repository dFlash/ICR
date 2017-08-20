package com.mg.icr.model.dto;

import com.mg.icr.model.BonusType;
import lombok.Data;

@Data
public class BonusTypeDto {

    private Integer id;

    private String type;

    public BonusTypeDto(BonusType bonusType) {
        this.id = bonusType.getId();
        this.type = bonusType.getType();
    }

}
