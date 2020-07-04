package servlet;

import dao.SelectDAO;
import dbc.DatabaseConnection;
import impl.selectDataImpl;
import vo.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author Hesenbai
 */
public class SelectServlet extends HttpServlet {
        private DatabaseConnection conn = null;

        public void SearchServlet(){
            try {
                this.conn = new DatabaseConnection();
            }
            catch (Exception e){
                e.printStackTrace();
            }


        }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        selectDataImpl dao = new selectDataImpl(this.conn.getConnection());
        List<User> users = dao.getAllUsers();
        req.setAttribute("users",users);
        req.getRequestDispatcher("selectPage.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
