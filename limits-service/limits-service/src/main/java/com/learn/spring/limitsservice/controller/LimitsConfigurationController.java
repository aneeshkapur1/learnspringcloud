package com.learn.spring.limitsservice.controller;

import com.learn.spring.limitsservice.config.Configuration;
import com.learn.spring.limitsservice.model.LimitsConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LimitsConfigurationController {

    @Autowired
    private Configuration config;

    @GetMapping("/limits")
    public LimitsConfiguration retrieveLimitsFromConfiguration()
    {
        return new LimitsConfiguration(config.getMinimum(),config.getMaximum());
    }
}

