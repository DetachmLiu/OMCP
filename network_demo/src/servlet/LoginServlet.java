package servlet;

import factory.DaoFactory;
import vo.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;


/**
 * @author Hesenbai
 */

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path="login.jsp";
        String email=req.getParameter("email");
        String psw=req.getParameter("psw");
        List<String> info=new ArrayList<String>();
        resp.setContentType("text/html;charset = utf-8");
        boolean flag;
        if(email==null||"".equals(email)) {
            info.add("邮件地址不能为空!");
        }
        if(psw==null||"".equals(psw)) {
            info.add("密码不能为空!");
        }
        if(info.size()==0) {
            User user=new User();
            user.setEmail(email);
            user.setPsw(psw);
            PrintWriter out = resp.getWriter();
            try {
                flag = DaoFactory.getUserDaoInstance().findLogin(user);
                if(flag) {
                    resp.sendRedirect("main.jsp");

                }else {

                    info.add("用户登录失败，错误的email或密码！");
                    req.setAttribute("info", info);
                    req.getRequestDispatcher(path).forward(req, resp);
                }

            }catch(Exception e ) {
                e.printStackTrace();
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
