package dao;
import vo.User;

/**
 * @author hesenbai
 */
public interface IregisterDAO {

    /**  注册操作
     *  数据库的增加操作
     */

    public boolean doCreate(User user)throws Exception;
}
