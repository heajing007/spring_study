import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DesignTest {
    public static void main(String[] args) {
        Stu stu = new Stu();
        InvocationHandler stuHandler = new MyInvocationHandler<Person>(stu);
        Person stuProxy = (Person) Proxy.newProxyInstance(Person.class.getClassLoader(), new Class<?>[]{Person.class},stuHandler);
        stuProxy.talk();
    }


}
class MyInvocationHandler<T> implements InvocationHandler {
    private T target;

    public MyInvocationHandler(T _obj){
        this.target = _obj;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("开始");
        System.out.println(method.getName());
        Object invoke = method.invoke(this.target, args);
        System.out.println("结束");
        return invoke;
    }
}

interface Person{
    public void talk();
}

class Stu implements Person{
    public void talk(){
        System.out.println("11111");
    }
    public void play(){
        System.out.println("22222");
    }
}