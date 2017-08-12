package com.mg.icr.service;

import com.mg.icr.logic.SkillTypeLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SkillTypeService {

    @Autowired
    private SkillTypeLogic skillTypeLogic;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getAllSkillTypes() {
        return skillTypeLogic.findAll().toString();
    }
}
