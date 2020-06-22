package proxy;

import dao.IUserDAO;
import dbc.DatabaseConnection;
import impl.UserDaoImpl;
import vo.User;

/**
 * @author Hesenbai
 */
public class UserDaoProxy implements IUserDAO{
    private DatabaseConnection dbc=null;

    private IUserDAO dao=null;

    public UserDaoProxy() {
        try {
            this.dbc= new DatabaseConnection();
        }catch(Exception e) {
            e.printStackTrace();
        }
        this.dao=new UserDaoImpl(this.dbc.getConnection());
    }

    @Override
    public boolean findLogin(User user) throws Exception{
        boolean flag;
        try {
            flag=this.dao.findLogin(user);

        }catch(Exception e) {
            throw e;
        }finally {
            this.dbc.close();
        }
        return flag;
    }

}
