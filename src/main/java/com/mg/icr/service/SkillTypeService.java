package com.mg.icr.service;

import com.mg.icr.logic.SkillTypeLogic;
import com.mg.icr.model.dto.SkillTypeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.apache.log4j.*;

import java.util.List;

@RestController
public class SkillTypeService {
    private static final Logger log = Logger.getLogger(SkillTypeService.class);

    @Autowired
    private SkillTypeLogic skillTypeLogic;

    @RequestMapping(value = "/skillType", method = RequestMethod.GET)
    @ResponseBody
    public List<SkillTypeDto> getAllSkillTypes()
    {
        return skillTypeLogic.findAll();
    }

    @RequestMapping(value = "/skillTypeId", method = RequestMethod.GET)
    @ResponseBody
    public SkillTypeDto getSkillTypeById(Integer skillTypeId) { return skillTypeLogic.findById(skillTypeId);}

}
