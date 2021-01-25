import com.dao.BlogMapper;
import com.pojo.Blog;
import com.utils.IDUtils;
import com.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.*;

public class MyTest {

    @Test
    public void addInitBlog(){
        SqlSession session = MybatisUtils.getSqlSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);

        Blog blog = new Blog();
        blog.setId(IDUtils.getId());
        blog.setTitle("Mybatis如此简单");
        blog.setAuthor("kc");
        blog.setCreate_time(new Date());
        blog.setViews(9999);

        mapper.addBlog(blog);

        blog.setId(IDUtils.getId());
        blog.setTitle("Java如此简单");
        mapper.addBlog(blog);

        blog.setId(IDUtils.getId());
        blog.setTitle("Spring如此简单");
        mapper.addBlog(blog);

        blog.setId(IDUtils.getId());
        blog.setTitle("微服务如此简单");
        mapper.addBlog(blog);

        session.close();

    }

    @Test
    public void queryBlogIF(){
        SqlSession session = MybatisUtils.getSqlSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);

        Map map = new HashMap();
        map.put("title", "Java如此简单3");

        List<Blog> blogs = mapper.queryBlogIF(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }

        session.close();
    }

    @Test
    public void queryBlogChoose(){
        SqlSession session = MybatisUtils.getSqlSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);

        Map map = new HashMap();
        map.put("title", "Java如此简单");

        List<Blog> blogs = mapper.queryBlogChoose(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }

        session.close();
    }

    @Test
    public void queryBlogForeach(){
        SqlSession session = MybatisUtils.getSqlSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);

        Map map = new HashMap();

        ArrayList<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(2);

        map.put("ids", ids);
        List<Blog> blogs = mapper.queryBlogForeach(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }

        session.close();
    }

    @Test
    public void updateBlog(){
        SqlSession session = MybatisUtils.getSqlSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);

        Map map = new HashMap();
        map.put("title", "Java如此简单3");
        map.put("author","kuangcheng2");
        map.put("id","2");

        int num = mapper.updateBlog(map);
        System.out.println(num);

        session.close();
    }
}
