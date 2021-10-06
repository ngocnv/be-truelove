package com.nvgroupitech.truelove.handler;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.nvgroupitech.truelove.controller.UserController;
import com.nvgroupitech.truelove.dto.ErrorDTO;
import com.nvgroupitech.truelove.enums.ErrorMessages;
import com.nvgroupitech.truelove.exceptions.ApiRuntimeException;
import com.nvgroupitech.truelove.utils.ApiUtil;

@Aspect
@Component
@ControllerAdvice(basePackageClasses = UserController.class)
@Order(2)
public class AppExceptionHandler {
   
    private static final Logger logger = LoggerFactory.getLogger(AppExceptionHandler.class);
    
    @Autowired
	private MessageSource messageSource;
   

    
    /**
	 * Handle other exception.
	 *
	 * @param e
	 * @return response entity
	 */
	@ExceptionHandler(value = { Exception.class, RuntimeException.class })
	public ResponseEntity<ErrorDTO> commonException(final Exception e) {
		logger.info("CommonExceptionHandler.exception() : --------Beginning handle exception--------------");
		logger.error("Error : {}", ExceptionUtils.getStackTrace(e));
		logger.error("[API_ERROR] An error occurred in the validation check（{}）", ApiUtil.getJsonRequestString());
	
		String errorMessage = this.messageSource.getMessage(ErrorMessages.E0001.getErrorDefaultMsgCd(), null,
				ApiUtil.getLocale());

		return new ResponseEntity<>(ApiUtil.getErrorMessage(ErrorMessages.E0001.getErrorCode(),
				errorMessage), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value = { ApiRuntimeException.class })
	public ResponseEntity<ErrorDTO> apiException(final ApiRuntimeException e) {
		logger.error("Error : {}", ExceptionUtils.getStackTrace(e));
		logger.error("[API_ERROR] An error occurred in the validation check（{}）", ApiUtil.getJsonRequestString());
	
		return new ResponseEntity<>(ApiUtil.getErrorMessage(e.getError().getErrorCode(),e.getMessage()), e.getError().getHttpStatusCode());
	}
}
