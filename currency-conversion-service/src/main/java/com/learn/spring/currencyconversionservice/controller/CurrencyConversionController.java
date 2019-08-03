package com.learn.spring.currencyconversionservice.controller;


import com.learn.spring.currencyconversionservice.model.CurrencyConversionBean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;


@RestController
public class CurrencyConversionController {



    @RequestMapping(path = "/currency-converter/from/{from}/to/{to}/quantity/{quantity}",method = RequestMethod.GET)
    public CurrencyConversionBean convertCurrency(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity)
    {
        Map<String,String> uriVariables = new HashMap<>();

        uriVariables.put("from",from);
        uriVariables.put("to",to);


        ResponseEntity<CurrencyConversionBean> responseEntity =  new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}",CurrencyConversionBean.class,uriVariables);

        CurrencyConversionBean response = responseEntity.getBody();

        return new CurrencyConversionBean(response.getId(),from,to,response.getConversionMultiple(),quantity,quantity.multiply(response.getConversionMultiple()),0);

    }


}
