package com.nvgroupitech.truelove.filter;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;
import org.springframework.web.filter.GenericFilterBean;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class RequestJsonLogFilter extends GenericFilterBean {
	
	private static final Logger logger = LogManager.getLogger(RequestJsonLogFilter.class);

	private static final String HTTP_HEADER_CONTENT_TYPE = "Content-Type";
	private static final String HTTP_CONTENT_TYPE_APPLICATION_JSON = "application/json";

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) req;
		String contentType = httpRequest.getHeader(HTTP_HEADER_CONTENT_TYPE);
		 
		if (!httpRequest.getRequestURI().startsWith("/actuator")) {
			logger.info("receive request ---- "+ httpRequest.getMethod()+" " +httpRequest.getRequestURI() );
			CachedBodyHttpServletRequest cachedBodyHttpServletRequest = new CachedBodyHttpServletRequest(httpRequest);
			InputStream inputStream = cachedBodyHttpServletRequest.getInputStream();
			 byte[] body = StreamUtils.copyToByteArray(inputStream);
			
		     logger.info("body request --- : " + new String(body));
		     chain.doFilter(cachedBodyHttpServletRequest, res);
		     return;
		}
		chain.doFilter(req, res);
	}

	protected InputStream getRequestBody(HttpServletRequest request) {
		InputStream requestEntity = null;
		try {
			requestEntity = request.getInputStream();
			

		} catch (IOException ex) {
			logger.error("error during getRequestBody", ex);
		}
		return requestEntity;
	}
	
}
