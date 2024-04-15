package design_patterns.strategy;

/**
 * @Description
 * @Date 2024/3/27 20:17
 */
public class JndiDao implements UserDao{
    private String name = "JndiDao";

    @Override
    public void insert() {
        System.out.println(name + "insert");
    }

    @Override
    public void update() {
        System.out.println(name + "update");
    }

    @Override
    public void delete() {
        System.out.println(name + "delete");
    }

    @Override
    public void findById() {
        System.out.println(name + "findById");
    }
}
