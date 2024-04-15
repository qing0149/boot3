package design_patterns.adapter;

/**
 * @Description
 * @Date 2024/4/15 19:40
 */
public class Client {
    public static void main(String[] args) {
        UserService userService = new UserService();
        SpecUserServiceAdapter specUserServiceAdapter = new SpecUserServiceAdapter(userService);
        System.out.println(specUserServiceAdapter.studentListJson());
    }

}
