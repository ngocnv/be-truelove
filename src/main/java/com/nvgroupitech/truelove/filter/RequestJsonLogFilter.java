package com.nvgroupitech.truelove.filter;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;
import org.springframework.web.filter.GenericFilterBean;

import com.nvgroupitech.truelove.constant.CommonConstant;
import com.nvgroupitech.truelove.utils.ApiUtil;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class RequestJsonLogFilter extends GenericFilterBean {
	
	private static final Logger logger = LoggerFactory.getLogger(RequestJsonLogFilter.class);

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) req;
		logger.info("receive request ---- "+ httpRequest.getMethod()+" " +httpRequest.getRequestURI() );
		if (!httpRequest.getRequestURI().startsWith("/truelove/actuator")) {
			
			CachedBodyHttpServletRequest cachedBodyHttpServletRequest = new CachedBodyHttpServletRequest(httpRequest);
			InputStream inputStream = cachedBodyHttpServletRequest.getInputStream();
			 byte[] body = StreamUtils.copyToByteArray(inputStream);
			
		  
		 	ApiUtil.putLocalContext(CommonConstant.JSON_REQUEST, new String(body));
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
