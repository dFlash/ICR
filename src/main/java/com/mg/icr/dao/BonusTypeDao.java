package com.mg.icr.dao;

import com.mg.icr.model.BonusType;

import java.util.List;

public interface BonusTypeDao {

    List<BonusType> findAll();

    BonusType find(Integer id);

    void save(BonusType bonusType);

    void update(BonusType bonusType);

    void delete(BonusType bonusType);
}
