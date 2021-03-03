import com.dao.UserDao;
import com.dao.UserDaoImpl;
import com.service.UserService;
import com.service.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class My_Test {

    @Test
    public void test() {
        // 用户实际调用的是业务层，dao层他们不需要调用
        UserService userService = new UserServiceImpl();
        ((UserServiceImpl) userService).setUserDao(new UserDaoImpl());
        userService.getUser();
    }

    @Test
    public void test2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        UserServiceImpl userServiceImpl = (UserServiceImpl) context.getBean("userserviceimpl");
        userServiceImpl.getUser();



    }
}
