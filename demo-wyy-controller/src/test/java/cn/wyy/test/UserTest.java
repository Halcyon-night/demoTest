package cn.wyy.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class UserTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		//加载单个spring文件
		 ApplicationContext context = new ClassPathXmlApplicationContext("spring-global-db.xml");
	}

	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
