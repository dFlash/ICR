package com.mg.icr.service;

import com.mg.icr.logic.BonusTypeLogic;
import com.mg.icr.model.dto.BonusTypeDto;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BonusTypeService {

    private static final Logger LOGGER = Logger.getLogger(BonusTypeService.class);

    @Autowired
    private BonusTypeLogic bonusTypeLogic;

    @RequestMapping(value = "/bonus-type", method = RequestMethod.GET)
    @ResponseBody
    public List<BonusTypeDto> findAll() {
        LOGGER.info("Select all bonus types");
        return bonusTypeLogic.findAll();
    }

    @RequestMapping(value = "/bonus-type/{id}", method = RequestMethod.GET)
    @ResponseBody
    public BonusTypeDto find(@PathVariable Integer id) {
        LOGGER.info(String.format("Select bonus type by id %d", id));
        return bonusTypeLogic.find(id);
    }

    @RequestMapping(value = "/bonus-type", method = RequestMethod.POST)
    public ResponseEntity add(@RequestBody BonusTypeDto bonusTypeDto) {
        LOGGER.info("Save bonus type");
        bonusTypeLogic.add(bonusTypeDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/bonus-type", method = RequestMethod.PUT)
    public ResponseEntity update(@RequestBody BonusTypeDto bonusTypeDto) {
        LOGGER.info(String.format("Update bonus type %d", bonusTypeDto.getId()));
        bonusTypeLogic.update(bonusTypeDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/bonus-type/{id}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable Integer id) {
        LOGGER.info(String.format("Delete bonus type %d", id));
        bonusTypeLogic.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
