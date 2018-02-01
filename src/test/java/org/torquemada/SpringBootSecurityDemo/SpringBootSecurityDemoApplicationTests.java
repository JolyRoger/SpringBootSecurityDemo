package org.torquemada.SpringBootSecurityDemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.torquemada.SpringBootSecurityDemoApplication;
import org.torquemada.WebSecurityConfig;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {SpringBootSecurityDemoApplication.class, WebSecurityConfig.class})
public class SpringBootSecurityDemoApplicationTests {

	@Test
	public void myTest() {
        assertTrue(true);
	}
}
