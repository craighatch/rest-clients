package com.credera.examples.serialization.dto.example;

import java.util.List;

/*
Compare the fields in this class with the serialized json in resources/serialization/example.json
 */
public class Example {
    private String fieldOne;
    private Integer fieldTwo;
    private List<String> fieldThree;
    private SecondaryObject fieldFour;

    //getters and setters

    static class SecondaryObject {
        private boolean fieldFive;
        //getters and setters
    }
}

