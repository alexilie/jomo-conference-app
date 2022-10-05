package com.jomo.conferencedemo.controllers;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.MonthDay;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class ErrorController {

    @Value("${app.error.message}")
    private String applicationErrorMessage;

    public ErrorController() {
    }

    public ErrorController(String applicationErrorMessage) {
        this.applicationErrorMessage = applicationErrorMessage;
    }

    @GetMapping
    @RequestMapping("/api/v1/error")
    public Map getError(){
        Map map = new HashMap<String, String>();
        map.put("application-error", applicationErrorMessage);
        return map;
    }
}
