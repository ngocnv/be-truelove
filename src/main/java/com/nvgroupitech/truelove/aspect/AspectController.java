package com.nvgroupitech.truelove.aspect;

import java.util.UUID;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nvgroupitech.truelove.constant.CommonConstant;
import com.nvgroupitech.truelove.service.KeycloakService;
import com.nvgroupitech.truelove.utils.SharedUtil;

@Aspect
@Component
public class AspectController {
	
	@Autowired
	private KeycloakService keycloakService;
	
	@AfterThrowing(pointcut = "execution(* com.nvgroupitech.truelove.controller.UserController.createUser(..))")
	public void createUserFailed() {
		UUID keycloakId = (UUID)SharedUtil.getKey(CommonConstant.KEYCLOAK_ID);
		if(keycloakId !=null) {
			keycloakService.deleteUser(keycloakId);
		}
	}
}
