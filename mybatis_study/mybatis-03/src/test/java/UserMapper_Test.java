import com.dao.UserMapper;
import com.pojo.User;
import com.utils.MybatisUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMapper_Test {

    static Logger logger = Logger.getLogger(UserMapper_Test.class); //LogDemo为相关的类
    @Test
    public void getUserList() {
        //第一步：获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //方式一：getMapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.getUserList();

        for (User user : userList) {
            System.out.println(user);
        }

        //关闭SqlSession
        sqlSession.close();
    }

    @Test
    public void getUserLimit(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        Map<String,Integer> map = new HashMap();
        map.put("StartIndex", 0);
        map.put("PageSize", 2);
        List<User> userList = userMapper.getUserLimit(map);

        for (User user : userList) {
            System.out.println(user);
        }

        //关闭SqlSession
        sqlSession.close();
    }

    @Test
    public void getUserRowBounds(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        // RowBounds实现
        RowBounds rowBounds = new RowBounds(1, 2);
        //通过Java代码层面实现分页
        List<User> userList = sqlSession.selectList("com.dao.UserMapper.getUserRowBounds",null,rowBounds);

        for(User user : userList){
            System.out.println(user);
        }
        //关闭SqlSession
        sqlSession.close();
    }

    @Test
    public void testlog4j(){
        logger.info("info 使用 log4j");
        logger.debug("debug 进入 log4j");
        logger.error("error 进入 log4j");
    }

    @Test
    public void getUserById(){
        //第一步：获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //方式一：getMapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.getUserById(1);
        System.out.println(user);

        //关闭SqlSession
        sqlSession.close();
    }

    @Test
    public void getUserLike(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.getUserLike("李");
        for(User user : userList){
            System.out.println(user);
        }

        sqlSession.close();
    }

    @Test
    public void addUser(){
        //第一步：获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //方式一：getMapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int num = userMapper.addUser(new User(4,"kuangcheng","123456"));
        System.out.println(num);

        // 提交事物
        sqlSession.commit();

        // 查询所有事物
        List<User> userList = userMapper.getUserList();

        for (User user : userList) {
            System.out.println(user);
        }

        //关闭SqlSession
        sqlSession.close();

    }

    @Test
    public void addUser2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        // 创建 map
        Map map = new HashMap();
        map.put("Userid", 12);
        map.put("Username", "cat");
        map.put("Userpwd", "1234595");

        int num = userMapper.addUser2(map);
        System.out.println(num);

        // 提交事物
        sqlSession.commit();
        // 关闭 sqlSession
        sqlSession.close();

    }

    @Test
    public void updateUser(){
        //第一步：获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //方式一：getMapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int num = userMapper.updateUser(new User(4,"kc","88888888"));
        System.out.println(num);

        // 提交事物
        sqlSession.commit();

        //关闭SqlSession
        sqlSession.close();
    }

    @Test
    public void deleteUser(){
        //第一步：获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //方式一：getMapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int num = userMapper.deleteUser(52);
        System.out.println(num);

        // 提交事物
        sqlSession.commit();

        //关闭SqlSession
        sqlSession.close();
    }


}
