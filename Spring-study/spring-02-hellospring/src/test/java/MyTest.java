import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.Hello;

public class MyTest {

    public static void main(String[] args) {

        // 获取 Spring 的上下文对象
        ApplicationContext context =
                new ClassPathXmlApplicationContext("beans.xml");

        // 我们的对象现在都在Spring中管理
        Hello hello = (Hello)context.getBean("hello2");
        System.out.println(hello.toString());
    }
}
