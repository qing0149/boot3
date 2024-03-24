package design_patterns.chain;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: Boot3
 * @description:
 * @author:
 * @create: 2024-03-08 14:35
 **/
public class Client {
    public static void main(String[] args) {
        //1.构建调用链
        AuthHandler authHandler = new AuthHandler();
        CacheHandler cacheHandler = new CacheHandler();
        MetricsHandler metricsHandler = new MetricsHandler();
        ProceedHandler proceedHandler = new ProceedHandler();
        authHandler.setNext(metricsHandler);
        metricsHandler.setNext(cacheHandler);
        cacheHandler.setNext(proceedHandler);
        Map request = new HashMap<>();
        request.put("username", "admin");
        request.put("password", "123456");
        authHandler.handle(request);
    }
}
