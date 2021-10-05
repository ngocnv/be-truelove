package com.nvgroupitech.truelove.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.net.ssl.SSLSocket;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nvgroupitech.truelove.context.ApplicationContextHolder;

public class HttpUtil {
	
	private static final Logger logger = LoggerFactory.getLogger(HttpUtil.class);
	
    public static CloseableHttpClient setViaSocketFactory() {
        SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
          SSLContexts.createDefault(),
          new String[] { "TLSv1.2", "TLSv1.3" },
          null,
          SSLConnectionSocketFactory.getDefaultHostnameVerifier());

        return HttpClients.custom().setSSLSocketFactory(sslsf).build();
    }
    
    public static CloseableHttpClient setTlsVersionPerConnection() {
        SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(SSLContexts.createDefault()) {

            @Override
            protected void prepareSocket(SSLSocket socket) {
                String hostname = socket.getInetAddress().getHostName();
                if (hostname.endsWith("internal.system.com")) {
                    socket.setEnabledProtocols(new String[] { "TLSv1", "TLSv1.1", "TLSv1.2", "TLSv1.3" });
                } else {
                    socket.setEnabledProtocols(new String[] { "TLSv1.3" });
                }
            }
        };

        return HttpClients.custom().setSSLSocketFactory(sslsf).build();
    }
    
    // To configure the TLS versions for the client, set the https.protocols system property during runtime.
    // For example: java -Dhttps.protocols=TLSv1.1,TLSv1.2,TLSv1.3 -jar webClient.jar
    public static CloseableHttpClient setViaSystemProperties() {
        return HttpClients.createSystem();
        // Alternatively:
        // return HttpClients.custom().useSystemProperties().build();
    }

    public static  Map< String,String> request(String url,String method,Map<String,String> headers,Map<String,String> params) throws IOException {
        // Alternatively:
        // CloseableHttpClient httpClient = setTlsVersionPerConnection();
        // CloseableHttpClient httpClient = setViaSystemProperties();
    	Map<String,String> responseMap=new HashMap<>();
    	HttpUriRequest httpRequest=null;
    	if(method.equalsIgnoreCase("GET")) {
    		httpRequest = new HttpGet(url);
    	}else if(method.equalsIgnoreCase("POST")) {
    		httpRequest = new HttpPost(url);
    		List<NameValuePair> formParam = new ArrayList<NameValuePair>();
    		for(Entry<String, String> param: params.entrySet()) {
    			 formParam.add(new BasicNameValuePair(param.getKey(),param.getValue()));
    		}
    	 
    	    ((HttpPost) httpRequest).setEntity(new UrlEncodedFormEntity(formParam));
    	}
    	
    	for(Entry<String, String> header : headers.entrySet()) {
    		httpRequest.setHeader(header.getKey(),header.getValue());
    	}
        CloseableHttpClient httpClient =  ApplicationContextHolder.getBean(CloseableHttpClient.class);
        try (
            CloseableHttpResponse response =  httpClient.execute(httpRequest)) {
            HttpEntity entity = response.getEntity();
            responseMap.put("statusCode",response.getStatusLine().getStatusCode()+"" );
            responseMap.put("body",EntityUtils.toString(entity));
            return responseMap;
        }catch(Exception e) {
        	logger.error("Http Error : {}", ExceptionUtils.getStackTrace(e));
        	throw e;
        }
    }

}
