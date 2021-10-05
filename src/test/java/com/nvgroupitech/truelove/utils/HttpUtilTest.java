package com.nvgroupitech.truelove.utils;

import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.nvgroupitech.truelove.TrueloveApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TrueloveApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(
  locations = "classpath:application-integrationtest.properties")
public class HttpUtilTest {

	@Test
	public void testRequest() throws IOException {
		Map<String,String> headers = new HashMap<>();
		String clientId="truelove-app";
		String clientSecret="d3f77ad2-f8db-44e1-af0a-86f82c2e8067";
		
		String originalString=clientId+":"+clientSecret;
		String encodeString=new String(Base64.getEncoder().encode(originalString.getBytes()));
		headers.put("Authorization", "Basic "+encodeString);
		
		Map<String,String> formParams= new HashMap<>();
		formParams.put("grant_type","password");
		formParams.put("username", "usr0000145");
		formParams.put("password","Kdmxkmxmmxmx");
		
		Map<String,String> response = HttpUtil.request("https://keycloak.nvgroupitech.org/auth/realms/truelove/protocol/openid-connect/token", "POST", headers,formParams);
		
		
		
		Map<String,Object> json= JsonUtils.parse(response.get("body"));
		System.out.println(json.get("access_token"));
		
	}
}
