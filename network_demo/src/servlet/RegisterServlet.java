package servlet;

import factory.DaoFactory;
import vo.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Hesenbai
 */

public class RegisterServlet extends HttpServlet{
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String path="register.jsp";

        String name=request.getParameter("name");
        String age=request.getParameter("age");
        String email=request.getParameter("email");
        String psw=request.getParameter("psw");
        List<String> info=new ArrayList<String>();
        if(name==null||"".equals(name)) {
            info.add("姓名不能为空!");
        }
        if(age==null||"".equals(age)) {
            info.add("年龄不能为空!");
        }
        if(email==null||"".equals(email)) {
            info.add("邮件地址不能为空!");
        }
        if(psw==null||"".equals(psw)) {
            info.add("密码不能为空!");
        }
        if(info.size()==0) {
            User user=new User();
            user.setName(name);
            user.setAge(age);
            user.setEmail(email);
            user.setPsw(psw);
            try {
                if(DaoFactory.getIuserDaoInstance().doCreate(user)) {
                    info.add("用户注册成功，欢迎"+user.getName()+"加入！");

                }else {
                    info.add("用户注册失败，请重试！");
                }
            }catch(Exception e ) {
                e.printStackTrace();
            }
            request.setAttribute("info", info);
            request.getRequestDispatcher(path).forward(request, response);
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
