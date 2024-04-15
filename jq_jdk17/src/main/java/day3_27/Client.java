package day3_27;

import java.util.HashMap;

/**
 * @Description
 * @Date 2024/3/27 19:49
 */
public class Client {
    public static void main(String[] args) {
        LoginHandler loginHandler = new LoginHandler();
        loginHandler.setNext(new SexHandler());
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "admin");
        map.put("password", 123456);
        map.put("sex", 1);
        loginHandler.handler(map);
    }

}
