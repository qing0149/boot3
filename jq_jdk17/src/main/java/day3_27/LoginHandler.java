package day3_27;

import java.util.Map;

/**
 * @Description
 * @Date 2024/3/27 19:42
 */
public class LoginHandler extends AbstractHandler {

    @Override
    public void handler(Map<String, Object> map) {
        System.out.println("==========登录拦截器开始=========");
        String name = (String) map.get("name");
        Integer password = (Integer) map.get("password");
        if (name.equals("admin") && password.equals(123456)) {
            System.out.println("登录成功");
            if (null != super.getNext()) {
                super.getNext().handler(map);

            } else {
                System.out.println("======终止======");
            }
        }

        System.out.println("==========登录拦截器开始============");
    }
}
