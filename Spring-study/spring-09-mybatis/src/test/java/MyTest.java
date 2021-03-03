import com.mapper.UserMapper;
import com.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyTest {


    // 第一种，最原始的方法
    @Test
    public void Test1() throws IOException {
        String resources="mybatis-config.xml";
        InputStream in = Resources.getResourceAsStream(resources);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);     /// UserMapper为接口
        List<User> userList = mapper.selectUser();

        for (User user : userList) {
            System.out.println(user);
        }
    }

    // 第二种，使用 mybatis-spring 集成
    @Test
    public void Test2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserMapper userMapper = context.getBean("userMapper",UserMapper.class);
        for(User user : userMapper.selectUser()){
            System.out.println(user);
        }
    }

    // 第三种，进一步整合
    @Test
    public void Test3(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserMapper userMapper = context.getBean("userMapper2",UserMapper.class);
        for(User user : userMapper.selectUser()){
            System.out.println(user);
        }
    }

}
