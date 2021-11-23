import com.test.common.AutoWired;
import com.test.controller.UserController;
import com.test.entity.A;
import com.test.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
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

    @Test
    public void fun3(){
        A a = new A();
        Class<? extends A> aClass = a.getClass();
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field field : declaredFields){
            System.out.println(field.getName());
        }
    }

    @Test
    public void fun4() throws ClassNotFoundException {

        Class<?> aClass = Class.forName(A.class.getName());
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field field : declaredFields){
            System.out.println(field.getName());
        }
    }

    @Test
    public void fun5() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.add(Calendar.MONTH, -2);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        Date entryStartTime = calendar.getTime();
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        Date entryEndTime = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
        System.out.println(sdf.format(entryStartTime));
        System.out.println(sdf.format(entryEndTime));

    }

    @Test
    public void fun6() {
        String str1 = "202109";
        String str2 = "202108";
        System.err.println(str1.compareTo(str2));
//        Double v = (5 * 0.3 + 6 * 0.3);
//        System.out.println(v);
//        System.out.println(v.intValue());

//        Double x = 0D;
//        Integer y = 0;
//        Float z = 0F;
//        System.err.println(Objects.equals(x, 0D));
//        System.err.println(Objects.equals(y, 0));
//        System.err.println(x>=0);
//        System.err.println(Objects.equals(z, 0));
//        System.err.println(Objects.equals(z, 0F));


//        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        System.err.println(list.stream().filter(i -> Objects.equals(i, 2)).count());
//        System.err.println(list.stream().filter(i -> Objects.equals(i, 1)).count());

    }

}
