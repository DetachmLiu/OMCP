package impl;

import dao.IUserDAO;
import vo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author Hesenbai
 */
public class UserDaoImpl implements IUserDAO {

    private Connection conn=null;

    private PreparedStatement pstmt=null;

    public UserDaoImpl(Connection conn) {
        this.conn=conn;
    }

    @Override
    public boolean findLogin(User user)throws Exception{
        boolean flag=false;
        try {
            String sql="SELECT name FROM register WHERE email=?AND psw=?";
            this.pstmt=this.conn.prepareStatement(sql);
            this.pstmt.setString(1,user.getEmail());
            this.pstmt.setString(2,user.getPsw());
            ResultSet res=this.pstmt.executeQuery();
            if(res.next()) {
                user.setName(res.getString(1));
                flag=true;
            }
        }catch(Exception e){
            e.printStackTrace();
            System.out.print("验证错误");
        }finally {
            if(this.pstmt!=null) {
                try {
                    this.pstmt.close();
                }catch(Exception e) {
                    throw e;
                }
            }
        }
        return flag;
    }
}
