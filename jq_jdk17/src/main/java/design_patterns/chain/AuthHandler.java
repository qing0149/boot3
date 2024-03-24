package design_patterns.chain;

import java.util.Map;

/**
 * @program: Boot3
 * @description:
 * @author:
 * @create: 2024-03-08 14:10
 **/
public class AuthHandler extends AbstractHandler {
    @Override
    public void handle(Map<String, Object> request) {
        if (request.get("username").equals("admin") &&
                request.get("password").equals("123456")) {
            System.out.println("用户信息认证通过");
            if (this.getNext() != null) {
                this.getNext().handle(request);
            } else {
                throw new RuntimeException("请求没有被送达ProceedHandler");
            }
        } else {
            throw new RuntimeException("用户名或密码错误");
        }
    }
}
