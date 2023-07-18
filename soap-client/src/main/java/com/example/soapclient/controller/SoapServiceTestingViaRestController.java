/*
 *  Copyright (c) 2023 DMG
 *  All Rights Reserved Worldwide.
 *
 *  THIS PROGRAM IS CONFIDENTIAL AND PROPRIETARY TO DMG
 *  AND CONSTITUTES A VALUABLE TRADE SECRET.
 */

package com.example.soapclient.controller;

import com.example.stub.GetCountryRequest;
import com.example.stub.GetCountryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ws.client.core.WebServiceTemplate;

/**
 * @author Piyush Kumar.
 * @since 18/07/23.
 */
@RestController
public class SoapServiceTestingViaRestController {

    @Autowired
    private WebServiceTemplate webServiceTemplate;

    @GetMapping("/test-soap/country")
    public GetCountryResponse getCountry(){

        GetCountryRequest request = new GetCountryRequest();

        request.setName("India");

        GetCountryResponse response = (GetCountryResponse) webServiceTemplate.marshalSendAndReceive("http://localhost:8081/mySoapService", request);

        System.out.println("The response is ::: " + response.getCountry());
        System.out.println("The response is ::: " + response.getCountry().getCapital());
        System.out.println("The response is ::: " + response.getCountry().getName());
        System.out.println("The response is ::: " + response.getCountry().getPopulation());
        System.out.println("The response is ::: " + response.getCountry().getCurrency());

        return response;
    }
}
