package design_patterns.TemplateMethod;

/**
 * @Description
 * @Date 2024/4/16 16:36
 */
public class Twitter extends Network{

    @Override
    boolean logIn(String userName, String password) {
        return false;
    }

    @Override
    boolean sendData(byte[] data) {
        return false;
    }

    @Override
    void logOut() {
    }
}
