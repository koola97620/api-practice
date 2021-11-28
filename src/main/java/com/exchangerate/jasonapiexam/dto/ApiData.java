package com.exchangerate.jasonapiexam.dto;

import lombok.Data;

import java.util.Map;

@Data
public class ApiData {
    private Map<String, Double> quotes;
}
