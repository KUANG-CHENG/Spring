import com.dao.StudentMapper;
import com.dao.TeacherMapper;
import com.pojo.Student;
import com.pojo.Teacher;
import com.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.function.Consumer;

public class My_Test 
{
    @Test
    public void getTeacher(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //方式一：getMapper
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        List<Teacher> teachers = mapper.getTeacher();
        for(Teacher teacher: teachers){
            System.out.println(teacher);
        }

        //关闭SqlSession
        sqlSession.close();
    }


    @Test
    public void getTeacher1(){
        //第一步：获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //方式一：getMapper
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.getTeacher1(1);
        System.out.println(teacher);

        //关闭SqlSession
        sqlSession.close();
    }

    @Test
    public void getTeacher2(){
        //第一步：获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //方式一：getMapper
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.getTeacher2(1);
        System.out.println(teacher);

        //关闭SqlSession
        sqlSession.close();
    }
}
