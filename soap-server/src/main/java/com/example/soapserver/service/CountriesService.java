/*
 *  Copyright (c) 2023 DMG
 *  All Rights Reserved Worldwide.
 *
 *  THIS PROGRAM IS CONFIDENTIAL AND PROPRIETARY TO DMG
 *  AND CONSTITUTES A VALUABLE TRADE SECRET.
 */

package com.example.soapserver.service;

import com.example.stub.Country;
import com.example.stub.Currency;
import org.springframework.stereotype.Service;

/**
 * @author Piyush Kumar.
 * @since 17/07/23.
 */
@Service
public class CountriesService {

    public Country getCountry(String name){

        if (!"India".equalsIgnoreCase(name)){
            return null;
        }

        Country country = new Country();

        country.setCapital("New Delhi");
        country.setName("India");
        country.setCurrency(Currency.PLN);
        country.setPopulation(120); // in crores

        return country;
    }

}
