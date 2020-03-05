package com.converter.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ConverterService {
    public String toYaml(String jsonInput) throws IOException {
        JsonNode jsonNodeTree = new ObjectMapper().readTree(jsonInput);
        String jsonToYaml = new YAMLMapper().writeValueAsString(jsonNodeTree);
        return jsonToYaml;
    }
}
