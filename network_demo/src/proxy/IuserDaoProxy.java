package proxy;

import dao.IregisterDAO;
import dbc.DatabaseConnection;
import impl.RegisterDaoImpl;
import vo.User;

import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author Hesenbai
 */
public class IuserDaoProxy implements IregisterDAO{
    private DatabaseConnection dbc=null;

    private RegisterDaoImpl dao=null;

    public IuserDaoProxy()throws Exception{
        this.dbc=new DatabaseConnection();
        this.dao=new RegisterDaoImpl(this.dbc.getConnection());
    }

    @Override
    public boolean doCreate(User user)throws Exception{

        //标志位
        boolean flag= false;

        //未被注册允许创建
        String sql = "select * from register where name='"+user.getName()+"'";

        try {
            Statement stm = dbc.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            if(!rs.next()) {
                flag = this.dao.doCreate(user);
            }
        }catch(Exception e) {
            throw e;
        }finally {
            this.dbc.close();
        }
        return flag;
    }
}
