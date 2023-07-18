/*
 *  Copyright (c) 2023 DMG
 *  All Rights Reserved Worldwide.
 *
 *  THIS PROGRAM IS CONFIDENTIAL AND PROPRIETARY TO DMG
 *  AND CONSTITUTES A VALUABLE TRADE SECRET.
 */

package com.example.soapclient.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;

/**
 * @author Piyush Kumar.
 * @since 18/07/23.
 */
@Configuration
public class SoapClientConfig {

    @Bean
    Jaxb2Marshaller marshaller() {

        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setPackagesToScan("com.example.stub");
//        marshaller.setContextPath("com.example.stub"); // we can also use this.
        return marshaller;
    }

    @Bean
    WebServiceTemplate webServiceTemplate(Jaxb2Marshaller marshaller) {

        WebServiceTemplate webServiceTemplate = new WebServiceTemplate(marshaller);

//        We can also set the defaultUri, marshaller as below
//        webServiceTemplate.setDefaultUri("http://localhost:8081/mySoapService");
//        webServiceTemplate.setMarshaller(marshaller);
//        webServiceTemplate.setUnmarshaller(marshaller);
        return webServiceTemplate;
    }
}
