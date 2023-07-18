/*
 *  Copyright (c) 2023 DMG
 *  All Rights Reserved Worldwide.
 *
 *  THIS PROGRAM IS CONFIDENTIAL AND PROPRIETARY TO DMG
 *  AND CONSTITUTES A VALUABLE TRADE SECRET.
 */

package com.example.soapserver.endpoint;

import com.example.soapserver.service.CountriesService;
import com.example.stub.GetCountryRequest;
import com.example.stub.GetCountryResponse;
import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

/**
 * @author Piyush Kumar.
 * @since 17/07/23.
 */
@Endpoint
public class CountriesEndpoint {

    @Autowired
    private CountriesService countriesService;

//  This is meant for when jaxb2-maven-plugin xjc compiler using jakarta lib(i.e jaxb2-maven-plugin 3.1.0 version) for creating pojo with xml related annotations.
//  But, with this, there is one issue that when request is received, its field containing null value even when soap request is containing the field value
//  @PayloadRoot(
//        namespace = "http://www.example.com/stub",
//        localPart = "getCountryRequest"
//    )
//    @ResponsePayload
//  JAXBElement<GetCountryResponse> getCountryRes(@RequestPayload JAXBElement<GetCountryRequest> getCountryRequest) {
//
//      System.out.println("Received request" + getCountryRequest);
//      System.out.println("Received request" + getCountryRequest.getValue());
//      System.out.println("Received request" + getCountryRequest.getValue().getName());
//      System.out.println("Received request" + getCountryRequest.getName());
//      System.out.println("Received request" + getCountryRequest);
//      GetCountryResponse response = new GetCountryResponse();
//      response.setCountry(countriesService.getCountry(getCountryRequest.getValue().getName()));
//
//      QName name = new QName(getCountryRequest.getClass().getSimpleName());
//      return new JAXBElement<>(name, GetCountryResponse.class, response);
//  }


    @PayloadRoot(
        namespace = "http://www.example.com/stub",
        localPart = "getCountryRequest"
    )
    @ResponsePayload
    GetCountryResponse getCountryRes(@RequestPayload GetCountryRequest getCountryRequest) {

        System.out.println("Received request" + getCountryRequest);
        System.out.println("Received request" + getCountryRequest.getName());
        System.out.println("Received request" + getCountryRequest);
        GetCountryResponse response = new GetCountryResponse();
        response.setCountry(countriesService.getCountry(getCountryRequest.getName()));

        return response;
    }
}
