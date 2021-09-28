package truelove;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.nvgroupitech.truelove.TrueloveApplication;
import com.nvgroupitech.truelove.utils.SeqUtil;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = TrueloveApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(
  locations = "classpath:application-integrationtest.properties")
public class SeqUtilTest {

	@Test
	public void testUserCodeSeq() {
		String seqCode=SeqUtil.genSeq("USERCODE");
		assertEquals("USR0000001",seqCode);
		assertEquals("USR0000002",SeqUtil.genSeq("USERCODE"));
	}
}
