package impl;


import dao.SelectDAO;
import vo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Hesenbai
 */
public class selectDataImpl implements SelectDAO {
    private Connection conn = null;

    private PreparedStatement pstmt = null;

    public selectDataImpl(Connection conn) {
        this.conn=conn;
    }
    @Override
    public List<User> getAllUsers(){
        List<User> list = new ArrayList();
        String sql = "SELECT * FROM register;";
        try {
            this.pstmt = this.conn.prepareStatement(sql);
            ResultSet re =this.pstmt.executeQuery();
            while (re.next()){
                User user = new User();
                user.setEmail(re.getString("email"));
                user.setName(re.getString("name"));
                user.setAge(re.getString("age"));
                list.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

}
