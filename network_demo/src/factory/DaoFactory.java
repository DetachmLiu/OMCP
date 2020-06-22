package factory;
import dao.IUserDAO;
import dao.IregisterDAO;
import proxy.IuserDaoProxy;
import proxy.UserDaoProxy;

/**
 * @author Hesenbai
 */
public class DaoFactory {
    public static IUserDAO getUserDaoInstance() {
        return new UserDaoProxy();
    }

    public static IregisterDAO getIuserDaoInstance() throws Exception{ return new IuserDaoProxy(); }
}
