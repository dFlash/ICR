package com.mg.icr.logic;

import com.mg.icr.dao.BonusTypeDao;
import com.mg.icr.model.BonusType;
import com.mg.icr.model.dto.BonusTypeAssembler;
import com.mg.icr.model.dto.BonusTypeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
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

    @Override
    public void save(BonusTypeDto bonusTypeDto) {
        BonusType bonusType = BonusTypeAssembler.toEntity(bonusTypeDto);
        bonusTypeDao.save(bonusType);
    }

    @Override
    public void update(BonusTypeDto bonusTypeDto) {
        Optional<BonusType> bonusTypeOptional = Optional.ofNullable(
                bonusTypeDao.find(bonusTypeDto.getId()));
        bonusTypeOptional.ifPresent(bonusType -> {
            bonusType.setType(bonusTypeDto.getType());
            bonusTypeDao.update(bonusType);
        });
    }

    @Override
    public void delete(Integer id) {
        Optional<BonusType> bonusTypeOptional = Optional.ofNullable(
                bonusTypeDao.find(id));
        bonusTypeOptional.ifPresent(bonusType -> bonusTypeDao.delete(bonusType));
    }
}
