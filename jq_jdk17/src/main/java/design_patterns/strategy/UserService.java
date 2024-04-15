package design_patterns.strategy;

/**
 * @Description
 * @Date 2024/3/27 20:19
 */
public class UserService {
    public UserDao dao = null;

    public UserService(UserDao dao) {
        this.dao = dao;
    }

    public void createUser() {
        System.out.println("正在创建用户对象");
        dao.insert();
    }

}
