package design_test.china;

import java.io.IOException;
import java.util.HashMap;
import java.util.logging.SocketHandler;

/**
 * @Description
 * @Date 2024/3/26 20:21
 */
public class Client {
    public static void main(String[] args) throws IOException {
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "admin");
        map.put("score", 90);
        LoginHandler loginHandler = new LoginHandler();
        loginHandler.setNext(new ScoreHandler());
        loginHandler.handler(map);
    }

}
