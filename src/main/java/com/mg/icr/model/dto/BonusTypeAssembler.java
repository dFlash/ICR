package com.mg.icr.model.dto;

import com.mg.icr.model.BonusType;

import java.util.List;
import java.util.stream.Collectors;

public class BonusTypeAssembler {

    public static List<BonusTypeDto> toDTOList(List<BonusType> bonusTypes) {
        List<BonusTypeDto> bonusTypeDtos = bonusTypes.stream()
                .map(BonusTypeDto::new)
                .collect(Collectors.toList());
        return bonusTypeDtos;
    }

    public static BonusTypeDto toDTO(BonusType bonusType) {
        return bonusType == null ? null : new BonusTypeDto(bonusType);
    }

    public static BonusType toEntity(BonusTypeDto bonusTypeDto) {
        return BonusType.builder().type(bonusTypeDto.getType()).build();
    }
}
