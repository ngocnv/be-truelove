package com.nvgroupitech.truelove.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.nvgroupitech.truelove.dto.UserDTO;

@Component
public class UserValidator implements Validator {

    public boolean supports(Class clazz) {
        return UserDTO.class.equals(clazz);
    }

    public void validate(Object obj, Errors e) {
       
    }
    
}