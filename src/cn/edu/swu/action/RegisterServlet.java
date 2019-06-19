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
        //��һ����ͨ��service���������߼��ж��� ��ע��ɹ�
        boolean register = userService.register(name,password);
        //��һ���������ض������ע��ɹ�����response�������һ����½�Ľ���
        if (register){
        	System.out.println("4");
            response.sendRedirect(request.getContextPath()+"/index.jsp");
        }
        else {
            //��Ϊ��Ҫ��ӡ��������������ģ�������Ҫ����һ������
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("������������ù��ˣ���һ�����԰�~������<����>����ע����棩");
        }
        //���ʧ�ܾ��ڿͻ���������ϴ�ӡ��ע��ʧ�ܵ�����
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}