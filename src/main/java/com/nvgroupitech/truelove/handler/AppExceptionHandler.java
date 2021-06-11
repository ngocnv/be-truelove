package com.nvgroupitech.truelove.handler;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.nvgroupitech.truelove.constant.ErrorCode;
import com.nvgroupitech.truelove.controller.UserController;
import com.nvgroupitech.truelove.dto.ErrorDTO;

@Aspect
@Component
@ControllerAdvice(basePackageClasses = UserController.class)
@Order(2)
public class AppExceptionHandler {
    /**
     * logger.
     */
    private static final Logger logger = LogManager.getLogger(AppExceptionHandler.class);

    /**
     * Handle other exception.
     *
     * @param e
     * @return response entity
     */
    @ExceptionHandler(value = {Exception.class, RuntimeException.class})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ResponseEntity<ErrorDTO> exception(final Exception e) {
    	logger.error(ExceptionUtils.getStackTrace(e));
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setErrorCode(ErrorCode.DEFAULT_ERROR);
        errorDTO.setMessage(e.getMessage());
        logger.error(ExceptionUtils.getStackTrace(e));
        return new ResponseEntity<>(errorDTO, HttpStatus.OK);
    }
}
