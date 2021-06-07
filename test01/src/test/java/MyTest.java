import com.test.entity.A;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {

    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("tx.xml");
        context.getBean(A.class);
    }

    @Test
    public void fun1(){

    }

}
