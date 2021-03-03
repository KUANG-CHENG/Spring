import com.dao.UserMapper;
import com.pojo.User;
import com.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class My_Test {

    @Test
    public void Test1(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user1 = mapper.selectId(1);
        System.out.println(user1);
        System.out.println("************************************************");
        mapper.UpdateUser(new User(3, "mikfdsdfe", "666"));
        sqlSession.commit();

//        User user2 = mapper.selectId(2);
//        System.out.println(user2);
        sqlSession.close();
    }

    @Test
    public void Test2(){
        SqlSession sqlSession1 = MybatisUtils.getSqlSession();
        SqlSession sqlSession2 = MybatisUtils.getSqlSession();

        UserMapper mapper1 = sqlSession1.getMapper(UserMapper.class);
        User user1 = mapper1.selectId(1);
        System.out.println(user1);
        sqlSession1.close();

        System.out.println("***********************************************************");

        UserMapper mapper2 = sqlSession2.getMapper(UserMapper.class);
        User user2 = mapper2.selectId(1);
        System.out.println(user2);
        sqlSession2.close();
    }


}
