package impl;

import vo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * @author Hesenbai
 */
public class RegisterDaoImpl {
    private Connection conn=null;

    private PreparedStatement pstmt=null;

    public RegisterDaoImpl(Connection conn) {
        this.conn=conn;
    }

    public boolean doCreate(User user)throws Exception{
        boolean flag=false;
        String sql="INSERT INTO register(name,age,email,psw)VALUES(?,?,?,?)";
        this.pstmt=this.conn.prepareStatement(sql);
        this.pstmt.setString(1, user.getName());
        this.pstmt.setString(2, user.getAge());
        this.pstmt.setString(3,user.getEmail());
        this.pstmt.setString(4, user.getPsw());
        if(this.pstmt.executeUpdate()>0) {
            flag=true;
        }

        this.pstmt.close();
        return flag;
    }
}
