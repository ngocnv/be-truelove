package com.nvgroupitech.truelove.utils;

import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {
	public static Map<String, Object> parse(String json ) throws JsonMappingException, JsonProcessingException {       
        return new ObjectMapper().readValue(json, Map.class);
    }
}
