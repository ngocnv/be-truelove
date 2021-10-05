package com.nvgroupitech.truelove.config;

import java.util.Timer;
import java.util.TimerTask;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.http.impl.client.CloseableHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GlobalStartupConfig {
	
	@Autowired
	private CloseableHttpClient httpClient;
	private final Timer connectionManagerTimer = new Timer(
			"GameMicroserviceRoutingFilter.connectionManagerTimer", true);
	@PostConstruct
	private void initialize() {

		this.connectionManagerTimer.schedule(new TimerTask() {
			@Override
			public void run() {
				if (httpClient.getConnectionManager() == null) {
					return;
				}
				httpClient.getConnectionManager().closeExpiredConnections();
			}
		}, 30000, 5000);
	}
	

	@PreDestroy
	public void stop() {
		this.connectionManagerTimer.cancel();
	}
}
