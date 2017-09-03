package com.mg.icr.service;

import com.mg.icr.logic.SkillTypeLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.apache.log4j.*;

@RestController
public class SkillTypeService {
    private static final Logger log = Logger.getLogger(SkillTypeService.class);
    @Autowired
    private SkillTypeLogic skillTypeLogic;

}
