package com.controller;

import com.model.AWSmodel;
import com.service.SQLInterpreter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;


@Controller
public class mainControler {
    //TODO
    //input SQL query and get the response
    @ResponseBody
    @RequestMapping(value = "/query", method = RequestMethod.POST)
    public Map<String, Object> getDataBySQL(String query, String type) {
        return new SQLInterpreter(type).getData(query);
    }

    @RequestMapping(value = "/main")
    public String test() {
        return "homePage";
    }


}
