package com.nvgroupitech.truelove.exceptions;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import com.nvgroupitech.truelove.enums.ErrorMessages;

@Component
public class ApiRuntimeException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	private static MessageSource msgSrc;

	private ErrorMessages error;

	private Object[] params;


	@Autowired
	public void setMessageSourceAccessor(MessageSource newMsgSrc1) {
		ApiRuntimeException.msgSrc = newMsgSrc1;
	}


	public ApiRuntimeException() {
		super();
	}

	public ApiRuntimeException(String message_key, Locale locale) {
		super(msgSrc.getMessage(message_key, null, locale));
	}

	
	public ApiRuntimeException(final String messageKey, final ErrorMessages newError, final Locale locale) {
		super(msgSrc.getMessage(messageKey, null, locale));
		this.error = newError;
	}

	
	public ApiRuntimeException(final String messageKey, final Object[] newParams,
			final ErrorMessages newError, final Locale locale) {
		super(msgSrc.getMessage(messageKey, null, locale));
		this.error = newError;
		this.params = newParams;
	}

	public ErrorMessages getError() {
		return this.error;
	}


	public void setError(ErrorMessages newError) {
		this.error = newError;
	}

	public Object[] getParams() {
		return this.params;
	}

	
	public void setParams(Object[] newParams) {
		this.params = newParams;
	}
}
