import com.study.config.TestConfig;
import com.study.service.TestService;
import org.junit.Test;
import org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MySpringTest {

	@Test
	public void fun1(){
//		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();

		ac.register(TestConfig.class);
		//设置不支持循环依赖
//		AbstractAutowireCapableBeanFactory abf = (AbstractAutowireCapableBeanFactory) ac.getBeanFactory();
//		abf.setAllowCircularReferences(false);
		ac.refresh();


		TestService testBean = ac.getBean(TestService.class);
		System.out.println(testBean);
	}
}
