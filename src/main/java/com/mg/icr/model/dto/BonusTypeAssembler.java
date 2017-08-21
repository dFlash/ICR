package com.mg.icr.model.dto;

import com.mg.icr.model.BonusType;

import java.util.List;
import java.util.stream.Collectors;

public class BonusTypeAssembler {

    public static List<BonusTypeDto> toDtoList(List<BonusType> bonusTypes) {
        List<BonusTypeDto> bonusTypeDtos = bonusTypes.stream()
                .map(BonusTypeDto::new)
                .collect(Collectors.toList());
        return bonusTypeDtos;
    }

    public static BonusTypeDto toDto(BonusType bonusType) {
        return bonusType == null ? null : new BonusTypeDto(bonusType);
    }
}
