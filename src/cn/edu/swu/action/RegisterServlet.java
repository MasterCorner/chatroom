package cn.edu.swu.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.swu.service.UserService;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet(name = "RegisterServlet" ,urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(name+" "+password);
        UserService userService= new UserService();
        //这一步是通过service层做出的逻辑判断是 否注册成功
        boolean register = userService.register(name,password);
        //下一步是请求重定向，如果注册成功，就response给浏览器一个登陆的界面
        if (register){
        	System.out.println("4");
            response.sendRedirect(request.getContextPath()+"/index.jsp");
        }
        else {
            //因为需要打印给浏览器含有中文，所以需要设置一下字体
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("这个名字有人用过了，换一个试试吧~（请点击<后退>返回注册界面）");
        }
        //如果失败就在客户端浏览器上打印出注册失败的字样
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}