package com.controller;

import com.model.AWSmodel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.annotation.HttpMethodConstraint;
import java.util.List;

@Controller
public class mainControler {
    //TODO
    //input SQL query and get the response
    @ResponseBody
    @RequestMapping(value = "/query",method = RequestMethod.POST)
    public List<AWSmodel> getDataBySQL(String query)
    {
        return null;
    }
    //TODO
    //input SQL query and get the response
    @ResponseBody
    @RequestMapping(value = "/test")
    public String test()
    {
        return "Hello World";
    }
}
