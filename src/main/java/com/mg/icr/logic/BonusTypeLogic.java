package com.mg.icr.logic;

import com.mg.icr.model.dto.BonusTypeDto;

import java.util.List;

public interface BonusTypeLogic {

    List<BonusTypeDto> findAll();

    BonusTypeDto find(Integer id);

    void save(BonusTypeDto bonusTypeDto);

    void update(BonusTypeDto bonusTypeDto);

    void delete(Integer id);
}
