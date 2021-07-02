import com.study.config.TestConfig;
import com.study.service.TestService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MySpringTest {

	@Test
	public void fun1(){
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
		TestService testBean = ac.getBean(TestService.class);
		System.out.println(testBean);
	}
}
