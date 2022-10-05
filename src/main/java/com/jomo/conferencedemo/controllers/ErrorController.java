package com.jomo.conferencedemo.controllers;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("${app.description}")
    private String appDescription;

    @Value("${app.deployment.type}")
    private String appDeploymentType;

    @Value("${app.version}")
    private String appVersion;

    @Value("${app.status.running}")
    private String appStatusRunning;

    @Value("${company.owner}")
    private String appCompanyOwner;

    @Value("${spring.datasource.name}")
    private String springDataSourceName;

    @Value("${spring.datasource.port}")
    private String springDataSourcePort;

    @Value("${spring.datasource.url}")
    private String springDataSourceUrl;

    @Value("${spring.datasource.username}")
    private String springDataSourceUsername;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate localDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime localDateTime;

    @JsonFormat(pattern = "MM/dd")
    private MonthDay monthDay;

    private Date        date        = new Date();
    private long        timestamp   = date.getTime();

    public ErrorController(){
    }

    private String convertDatetoString() {
        return date.getYear()+"-"+
                date.getMonth()+"-"+
                date.getDay()+"-"+
                date.getDate()+"-"+
                date.getHours()+"-"+
                date.getMinutes()+"-"+
                date.getSeconds()+"-"+
                date.getTimezoneOffset();
    }

    public String getDatetoString() {
        return "HomeController{" +
                "localDate=" + localDate +
                ", localDateTime=" + localDateTime +
                ", monthDay=" + monthDay +
                ", date=" + date +
                ", timestamp=" + timestamp +
                '}';
    }

    public MonthDay getMonthDay() {
        return monthDay;
    }

    public void setMonthDay(MonthDay monthDay) {
        this.monthDay = monthDay;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }


    @GetMapping
    @RequestMapping("/error")
    public Map getConfig(){
        Map map = new HashMap<String, String>();
        map.put("app-datasource-name", springDataSourceName);
        map.put("app-datasource-port", springDataSourcePort);
        map.put("app-datasource-url", springDataSourceUrl);
        map.put("app-datasource-username", springDataSourceUsername);
        map.put("app-version", appVersion);

        map.put("date-info", getDatetoString());
        map.put("request-date", date.toString());
        map.put("request-timestamp", timestamp);
        map.put("date-conversion", convertDatetoString());
        map.put("application-error", applicationErrorMessage);

        return map;
    }
}
