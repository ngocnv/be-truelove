package com.nvgroupitech.truelove.config;

import java.util.concurrent.TimeUnit;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.config.RequestConfig.Builder;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;



@Component
public class AppConfig implements WebMvcConfigurer {

	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private CustomHttpClientConnectionManagerFactory customHttpClientConnectionManagerFactory;

	@Bean
	public LocalValidatorFactoryBean validator() {
		LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
		localValidatorFactoryBean.setValidationMessageSource(messageSource);
		return localValidatorFactoryBean;
	}
	
	@Override
	public Validator getValidator() {
		return validator();
	}
	
	@Bean
	public HttpClientBuilder httpClientBuilder() {
		HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
		httpClientBuilder.setDefaultRequestConfig(requestConfig());
		httpClientBuilder.setConnectionManager(connectionManager());
		return httpClientBuilder;
	}
	
	@Bean
	public RequestConfig requestConfig() {
		RequestConfig requestConfig = requestConfigBuilder().build();
		return requestConfig;
	}
	
	@Bean
	public Builder requestConfigBuilder() {
		Builder requestConfigBuilder = RequestConfig.custom();
		requestConfigBuilder.setSocketTimeout(3000);
		requestConfigBuilder.setConnectTimeout(3000);
		return requestConfigBuilder;
	}
	
	@Bean
	public CloseableHttpClient httpClient() {
		CloseableHttpClient httpClient = httpClientBuilder().build();
		return httpClient;
	}
	
	@Bean
	public HttpClientConnectionManager connectionManager() {
		boolean disableSslValidation=true;
		int maxTotalConnections=500;
		int maxConnectionsPerRoute=50;
		int timeToLive=900;
		TimeUnit timeUnit=TimeUnit.SECONDS;
		RegistryBuilder registryBuilder=null;
		return customHttpClientConnectionManagerFactory.newConnectionManager(disableSslValidation,maxTotalConnections,maxConnectionsPerRoute,timeToLive,timeUnit, null);
	}
	
	
	
}
