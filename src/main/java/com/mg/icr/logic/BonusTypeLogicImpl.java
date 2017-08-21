package com.mg.icr.logic;

import com.mg.icr.dao.BonusTypeDao;
import com.mg.icr.model.dto.BonusTypeAssembler;
import com.mg.icr.model.dto.BonusTypeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BonusTypeLogicImpl implements BonusTypeLogic{

    @Autowired
    private BonusTypeDao bonusTypeDao;


    @Override
    public List<BonusTypeDto> findAll() {
        return BonusTypeAssembler.toDtoList(bonusTypeDao.findAll());
    }

    @Override
    public BonusTypeDto find(Integer id) {
        BonusTypeDto bonusTypeDto = BonusTypeAssembler.toDto(bonusTypeDao.find(id));
        return bonusTypeDto;
    }
}
