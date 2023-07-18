/*
 *  Copyright (c) 2023 DMG
 *  All Rights Reserved Worldwide.
 *
 *  THIS PROGRAM IS CONFIDENTIAL AND PROPRIETARY TO DMG
 *  AND CONSTITUTES A VALUABLE TRADE SECRET.
 */

package com.example.soapserver.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

/**
 * @author Piyush Kumar.
 * @since 17/07/23.
 */
@EnableWs
@Configuration
public class SoapWebServiceConfig extends WsConfigurerAdapter {


    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext context){
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setTransformWsdlLocations(true);
        servlet.setApplicationContext(context);

        return new ServletRegistrationBean<>(servlet, "/mySoapService/*");
    }

    @Bean
    public XsdSchema countriesSchema(){
        return new SimpleXsdSchema(new ClassPathResource("countries.xsd"));
    }

    @Bean(name = "countries") // by this name, we will be accessing wsdl file on uri like http://localhost:8080/mySoapService/countries.wsdl
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema countriesSchema){
        DefaultWsdl11Definition definition = new DefaultWsdl11Definition();

        definition.setSchema(countriesSchema);
        definition.setLocationUri("/mySoapService");
        definition.setPortTypeName("countriesServicePort");
        definition.setTargetNamespace("http://www.example.com/stub");

        return definition;
    }
}
