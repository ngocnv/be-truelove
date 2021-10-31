package com.nvgroupitech.truelove.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
@TestPropertySource(locations = "classpath:application-integrationtest.properties")

public class AESUtilTest {

	@Test
	public void testEncrypt() {
		String adminPwd= "openkm@sfdsfdsfxxyydnv";
		String encrypt=AESUtil.encrypt(adminPwd.getBytes());
		System.out.println(encrypt);
	}
	
	@Test
	public void testDecrypt() {
		String adminPwd= "JY39BQNpHx4VuvBOhMp7ulsAAr300vNNw1g1eUFq6Gw=";
		String decrypt=AESUtil.decrypt(adminPwd);
		System.out.println(decrypt);
		assertEquals("openkm@sfdsfdsfxxyydnv", decrypt);
	}
}
