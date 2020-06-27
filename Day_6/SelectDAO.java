package dao;

import vo.User;

import java.util.List;

/**
 * @author axtb
 */
public interface SelectDAO {
    /**
     * 用户登录验证
     * @param user 传入vo对象
     * @return  返回查询的user信息
     *
     */
    List<User> getAllUsers();
}
