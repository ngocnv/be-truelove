package com.nvgroupitech.truelove.config;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;


@Configuration
public class JsonConfig extends WebMvcConfigurationSupport{
	
	  @Override
	    protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
	        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
	        ObjectMapper mapper = new ObjectMapper();
	        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
	        converter.setObjectMapper(mapper);
	        converters.add(converter);
	        super.configureMessageConverters(converters);
	    }
}
