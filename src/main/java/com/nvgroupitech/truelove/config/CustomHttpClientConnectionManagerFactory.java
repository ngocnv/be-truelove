package com.nvgroupitech.truelove.config;


import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.log4j.Logger;

import org.springframework.stereotype.Component;

@Component
public class CustomHttpClientConnectionManagerFactory {
	
	private transient final Logger log = Logger.getLogger(getClass());
	
	
	
	public static final String HTTP_SCHEME = "http";
	public static final String HTTPS_SCHEME = "https";
	public HttpClientConnectionManager newConnectionManager(boolean disableSslValidation,
			int maxTotalConnections, int maxConnectionsPerRoute, long timeToLive,
			TimeUnit timeUnit, RegistryBuilder registryBuilder) {
		if (registryBuilder == null) {
			registryBuilder = RegistryBuilder.<ConnectionSocketFactory> create()
					.register(HTTP_SCHEME, PlainConnectionSocketFactory.INSTANCE);
		}
		if (disableSslValidation) {
			try {
				final SSLContext sslContext = SSLContext.getInstance("SSL");
				sslContext.init(null,
					new TrustManager[] { new DisabledValidationTrustManager()},
					new SecureRandom());
				registryBuilder.register(HTTPS_SCHEME, new SSLConnectionSocketFactory(
					sslContext, NoopHostnameVerifier.INSTANCE));
			}
			catch (NoSuchAlgorithmException e) {
				log.warn("Error creating SSLContext", e);
			}
			catch (KeyManagementException e) {
				log.warn("Error creating SSLContext", e);
			}
		} else {
			registryBuilder.register("https", SSLConnectionSocketFactory.getSocketFactory());
		}
		final Registry<ConnectionSocketFactory> registry = registryBuilder.build();

		PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager(
				registry, null, null, null, timeToLive, timeUnit);
		connectionManager.setMaxTotal(maxTotalConnections);
		connectionManager.setDefaultMaxPerRoute(maxConnectionsPerRoute);

		return connectionManager;
	}
	
	class DisabledValidationTrustManager implements X509TrustManager {
		@Override
		public void checkClientTrusted(X509Certificate[] x509Certificates,
			String s) throws CertificateException {
		}

		@Override
		public void checkServerTrusted(X509Certificate[] x509Certificates,
			String s) throws CertificateException {
		}

		@Override
		public X509Certificate[] getAcceptedIssuers() {
			return null;
		}
	}
	

}
