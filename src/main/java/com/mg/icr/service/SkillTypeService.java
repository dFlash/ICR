package com.mg.icr.service;

import com.mg.icr.logic.SkillTypeLogic;
import com.mg.icr.model.dto.SkillTypeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.apache.log4j.*;

import java.util.List;

@RestController
public class SkillTypeService {
    private static final Logger LOGGER = Logger.getLogger(SkillTypeService.class);

    @Autowired
    private SkillTypeLogic skillTypeLogic;

    @RequestMapping(value = "/skill-type", method = RequestMethod.GET)
    @ResponseBody
    public List<SkillTypeDto> findAll()
    {
        LOGGER.info("Select all skill types");
        return skillTypeLogic.findAll();
    }

    @RequestMapping(value = "/skill-type/{id}", method = RequestMethod.GET)
    @ResponseBody
    public SkillTypeDto findById(@PathVariable Integer id) {
        LOGGER.info(String.format("Select skill type by id %d", id));
        return skillTypeLogic.findById(id);
    }

    @RequestMapping(value = "/skill-type", method = RequestMethod.POST)
    public ResponseEntity add(@RequestBody SkillTypeDto skillTypeDto) {
        LOGGER.info("Add skill type");
        skillTypeLogic.add(skillTypeDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/skill-type", method = RequestMethod.PUT)
    public ResponseEntity update(@RequestBody SkillTypeDto skillTypeDto) {
        LOGGER.info(String.format("Update skill type %d", skillTypeDto.getId()));
        skillTypeLogic.update(skillTypeDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/skill-type/{id}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable Integer id) {
        LOGGER.info(String.format("Delete skill type %d", id));
        skillTypeLogic.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

}
