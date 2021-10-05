package com.nvgroupitech.truelove.service.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.ws.rs.core.Response;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.keycloak.admin.client.CreatedResponseUtil;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.nvgroupitech.truelove.enums.ErrorMessages;
import com.nvgroupitech.truelove.exceptions.ApiRuntimeException;
import com.nvgroupitech.truelove.handler.AppExceptionHandler;
import com.nvgroupitech.truelove.models.jpa.entities.UserEntity;
import com.nvgroupitech.truelove.service.KeycloakService;

@Service
public class KeycloakServiceImpl implements KeycloakService {
	
	@Value("${keycloak.auth-server-url}")
	private String serverUrl;
	
	@Value("${keycloak.realm}")
	private String realm;
	
	@Value("admin-cli")
	private String clientId;
	
	@Value("${admin.keycloak.username}")
	private String username;
	
	@Value("${admin.keycloak.password}")
	private String password;
	
	private static Keycloak keycloak =null;
	
	private static final Logger logger = LoggerFactory.getLogger(AppExceptionHandler.class);

	private static final String DEFAULT_PASSWORD = "admin123";
	  private static final Object lockObject = new Object();
	  
	private void configKeycloak() {
		synchronized(lockObject) {
			if(keycloak==null) {
				 Keycloak newKeycloak = KeycloakBuilder.builder()
		                 .serverUrl(serverUrl)
		                 .realm("master") 
		                 .clientId(clientId)
		                 .username(username) 
		                 .password(password) 
		                 .resteasyClient(new ResteasyClientBuilder().connectionPoolSize(10).build())
		                 .build();
				 keycloak = newKeycloak;
		}
		}
	}

	@Override
	public UserEntity createUser(UserEntity user) {
        try {
           configKeycloak();
           
            // Define user
            UserRepresentation userRep = new UserRepresentation();

            userRep.setUsername(user.getUsername());
         
            userRep.setEmail(user.getEmailAddress());
            //Allow user login or not
            userRep.setEnabled(true);
            // set customize attribute
            Map<String, List<String>> attribute = new LinkedHashMap<String, List<String>>();
           userRep.setAttributes(attribute);
            // Get realm
            RealmResource realmResource = keycloak.realm(realm);
          
            UsersResource usersResource = realmResource.users();

            if (!CollectionUtils.isEmpty(usersResource.search(user.getUsername(),true))) {     
            	throw new ApiRuntimeException(ErrorMessages.E0002.getErrorDefaultMsgCd(),ErrorMessages.E0002,LocaleContextHolder.getLocale());
            }

            // Create user (requires manage-users role)
            Response response = usersResource.create(userRep);

            String userId = CreatedResponseUtil.getCreatedId(response);

            // Define password credential
            CredentialRepresentation passwordCred = new CredentialRepresentation();
            passwordCred.setTemporary(false);
            passwordCred.setType(CredentialRepresentation.PASSWORD);
            passwordCred.setValue(StringUtils.isNotEmpty(user.getPassword()) ? user.getPassword() : DEFAULT_PASSWORD);

            // Set password credential
            usersResource.get(userId).resetPassword(passwordCred);
            user.setKeycloakId(UUID.fromString(userId));

            return user;
        } catch (Exception e) {
            logger.error(ExceptionUtils.getStackTrace(e));
            throw e;
        }
	}

	public int deleteUser(UUID keycloakId) {
		try {
			// config keycloak
			configKeycloak();

			// Get realm
			RealmResource realmResource = keycloak.realm(realm);
			UsersResource usersRessource = realmResource.users();
			// Create user (requires manage-users role)

			Response response = usersRessource.delete(keycloakId.toString());
			return response.getStatus();

		} catch (Exception e) {
			logger.error("Something wrong when delete user with keycloakId={} !",keycloakId);
		}
		return -1;
	}

}
