package design_patterns.state;

/**
 * @Description
 * @Date 2024/4/17 11:45
 */
public class Client {
    public static void main(String[] args) throws Exception {
        User user = new User("Hello树先生");
        user.play720P();
        user.play1080P();
        user.play4K();
    }

}
