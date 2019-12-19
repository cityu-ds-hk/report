package edu.cityu.ds.report.controller;

import edu.cityu.ds.report.entity.Result;
import edu.cityu.ds.report.service.CommonService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Configuration
@Controller
@Tag(name = "Common Interfaces", description = "Rest API of common function")
@RequestMapping("/common")
public class CommonController {

    @Autowired
    private CommonService commonService;

    @RequestMapping(value = "/metaData", method = RequestMethod.GET)
    @ResponseBody
    public Result getMetaData(){
        return new Result(200, null, null, commonService.getMetaData());
    }

    @RequestMapping(value = "/allCount", method = RequestMethod.GET)
    @ResponseBody
    public Result getAllCount(){
        return new Result(200, null, null, commonService.getAllCount());
    }

}
