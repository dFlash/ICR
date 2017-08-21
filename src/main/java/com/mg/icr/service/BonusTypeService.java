package com.mg.icr.service;

import com.mg.icr.logic.BonusTypeLogic;
import com.mg.icr.model.dto.BonusTypeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BonusTypeService {

    @Autowired
    private BonusTypeLogic bonusTypeLogic;

    @RequestMapping(value = "/bonus-type", method = RequestMethod.GET)
    @ResponseBody
    public List<BonusTypeDto> findAll() {
        return bonusTypeLogic.findAll();
    }

    @RequestMapping(value = "/bonus-type/{id}", method = RequestMethod.GET)
    @ResponseBody
    public BonusTypeDto find(@PathVariable Integer id) {
        return bonusTypeLogic.find(id);
    }
}
