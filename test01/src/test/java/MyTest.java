import com.test.common.AutoWired;
import com.test.controller.UserController;
import com.test.entity.A;
import com.test.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.stream.Stream;

public class MyTest {

    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("tx.xml");
        context.getBean(A.class);
    }

    @Test
    public void fun1() throws Exception {
        UserController userController = new UserController();
        System.out.println(userController.getUserService());
        Class<? extends UserController> clazz = userController.getClass();
        UserService userService = new UserService();
        System.out.println(userService);

        //获取userService属性
        Field serviceField = clazz.getDeclaredField("userService");
        serviceField.setAccessible(true);
        String name = serviceField.getName();
        name = name.substring(0, 1).toUpperCase() + name.substring(1, name.length());
        //拼接后的方法名
        String setMethodName = "set" + name;

        //获取方法，设置参数方法类型
        Method method = clazz.getMethod(setMethodName, UserService.class);

        //执行方法， 传参
        method.invoke(userController, userService);
        System.out.println(userController.getUserService());

    }


    @Test
    public void fun2(){
        UserController userController = new UserController();
        System.out.println("userController:   "+userController.getUserService());
        Class<? extends UserController> clazz = userController.getClass();
        Stream.of(clazz.getDeclaredFields()).forEach(field -> {
            System.out.println("field:   "+ field);
            AutoWired annotation = field.getAnnotation(AutoWired.class);
            System.out.println("field.getAnnotation:   "+ annotation +'\n');
            if (annotation != null){
                field.setAccessible(true);
                //获取属性类型
                Class<?> type = field.getType();
                System.out.println("type:   "+type);
                try {
                    Object o = type.newInstance();
                    field.set(userController, o);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        System.out.println("userController:   "+userController.getUserService());

    }

}
