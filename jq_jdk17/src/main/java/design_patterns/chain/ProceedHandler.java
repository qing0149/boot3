package design_patterns.chain;

import java.util.Map;

/**
 * @program: Boot3
 * @description:
 * @author:
 * @create: 2024-03-08 14:32
 **/
public class ProceedHandler extends AbstractHandler {

    @Override
    public void handle(Map<String, Object> request) {
        System.out.println("请求已被转发给业务系统,完成后续业务处理");
    }
}
