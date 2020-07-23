package cn.wyy.test;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 单元测试的父类
 * @author 86158
 *
 */
@RunWith(SpringJUnit4ClassRunner.class) // 使用junit4进行测试
@ContextConfiguration(locations = { "classpath:applicationContext.xml", 
									"classpath:springmvc-servlet.xml",
									"classpath:mybatis-config.xml" }) // 加载配置文件
public class BaseJunit4Test {

}
