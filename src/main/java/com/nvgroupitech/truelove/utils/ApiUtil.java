package com.nvgroupitech.truelove.utils;

import java.util.Locale;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.nvgroupitech.truelove.context.SharedContext;
import com.nvgroupitech.truelove.dto.BaseDTO;
import com.nvgroupitech.truelove.dto.ErrorDTO;
import com.nvgroupitech.truelove.enums.ErrorMessages;
import com.nvgroupitech.truelove.enums.MessageLanguage;
import com.nvgroupitech.truelove.exceptions.ApiRuntimeException;

@Component
public class ApiUtil {
	private static final Logger logger = LoggerFactory.getLogger(ApiUtil.class);
	public static ErrorDTO getErrorMessage(String errorCode, String errorMessage) {
		ErrorDTO error = new ErrorDTO();
		error.setErrorCode(errorCode);
		error.setErrorMessage(errorMessage);
		return error;
	}

	public static <E extends BaseDTO> E getErrorMessage(Class<E> clazz, Errors errors){
		try {
			if (errors != null && errors.hasErrors()) {
				String errorCode = errors.getAllErrors().get(0).getCode();
				String errorMessage = errors.getAllErrors().get(0).getDefaultMessage();
				if (ErrorMessages.E0001 == ErrorMessages.getErrorMessages(errorCode)) {
					logger.error("An error occured in validation check（{}）",
							ApiUtil.getJsonRequestString());
				} else {
					logger.error("errorCode: {}, error Message: {}", errorCode, errorMessage);
				}
				E errorRes = clazz.newInstance();
				errorRes.setErrorCode(errorCode);
				errorRes.setErrorMessage(errorMessage);
				return errorRes;
			}
			return null;
		} catch (InstantiationException e) {
			logger.error("ApiUtil.getErrorMessage(): {}", e.getMessage());
			throw new ApiRuntimeException();

		} catch (IllegalAccessException e) {
			logger.error("ApiUtil.getErrorMessage(): {}", e.getMessage());
			throw new ApiRuntimeException();
		}
	}

	public static void putErrorMessage(MessageSource messageSource, Errors errors, ErrorMessages errorDtl) {
		if (errors == null) {
			logger.warn("ApiUtil.putErrorMessage: org.springframework.validation.Errors object is null!");
			return;
		}
		errors.reject(errorDtl.getErrorCode(), messageSource.getMessage(errorDtl.getErrorDefaultMsgCd(), null,
				getLocale()));
	}

	public static Locale getLocale() {
		String languageCode = SharedUtil.getLanguageCode();
		MessageLanguage language = MessageLanguage.getMessageLanguage(languageCode);
		if (language != null) {
			return new Locale(language.getId());
		}

		return LocaleContextHolder.getLocale();
	}

	public static String getJsonRequestString() {
		String json = SharedUtil.getJsonRequest();
		return json;
	}

	public static void putLocalContext(String key, String value) {
		boolean initialized = SharedContextHolder.alreadyInitializaed();
		SharedContext sc;
		if (!initialized) {
			sc = new SharedContext();
			SharedContextHolder.init(sc);
		} else {
			sc = SharedContextHolder.getSharedContext();
		}
		if (sc != null) {
			sc.putContext(key, value);
		}
	}
	public static void putLocalContext(String key, UUID value) {
		boolean initialized = SharedContextHolder.alreadyInitializaed();
		SharedContext sc;
		if (!initialized) {
			sc = new SharedContext();
			SharedContextHolder.init(sc);
		} else {
			sc = SharedContextHolder.getSharedContext();
		}
		if (sc != null) {
			sc.putContext(key, value);
		}
	}
	
}
