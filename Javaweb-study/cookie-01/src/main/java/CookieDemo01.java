import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Date;

public class CookieDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 解决中文乱码
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        PrintWriter out = resp.getWriter();

        // Cookie,服务器从客户端获取
        Cookie[] cookies = req.getCookies();

        // 判断 Cookie 是否存在
        if(cookies!=null){
            out.write("您上次访问本站的时间：");
            for(int i=0; i< cookies.length; i++){
                Cookie cookie = cookies[i];
                // 获取 cookie 的名字
                if(cookie.getName().equals("lastLoginTime")){
                    // 获取cookie的名字
                    long lastLoginTime = Long.parseLong(cookie.getValue());
                    Date date = new Date(lastLoginTime);
                    out.write(date.toLocaleString());
                }
            }
        }else{
            out.write("这是您第一次访问本站！！！");
        }

        // 服务端给客服端响应一个 cookie
        Cookie cookie = new Cookie("lastLoginTime",System.currentTimeMillis()+"");

        // 有效期一天
        cookie.setMaxAge(24*60*60);
        resp.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
