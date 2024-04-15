package design_patterns.strategy;

/**
 * @Description
 * @Date 2024/3/27 20:15
 */
public interface UserDao {
    public void insert();

    public void update();

    public void delete();

    public void findById();
}
