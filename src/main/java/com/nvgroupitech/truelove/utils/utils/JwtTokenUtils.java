package com.nvgroupitech.truelove.utils.utils;

import java.nio.charset.Charset;
import java.util.Base64;
import java.util.Map;
import java.util.regex.Pattern;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JwtTokenUtils {
	public static Map<String, Object> extract(String token) throws JsonMappingException, JsonProcessingException {
        String payload = token;
        String[] tokenParts = token.split(Pattern.quote("."));
        if (tokenParts.length > 1) {
            payload = tokenParts[1];
        }
        byte[] asBytes = Base64.getDecoder().decode(payload);
        
        return new ObjectMapper().readValue(new String(asBytes, Charset.forName("UTF-8")), Map.class);
    }
}
