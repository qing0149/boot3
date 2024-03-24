package design_patterns.chain;

import java.util.Map;

/**
 * @program: Boot3
 * @description:
 * @author:
 * @create: 2024-03-08 14:25
 **/
public class MetricsHandler extends AbstractHandler {

    @Override
    public void handle(Map<String, Object> request) {
        System.out.println("已获取当前运行指标并发送致Prometheus");
        if (this.getNext() != null) {
            this.getNext().handle(request);
        } else {
            throw new RuntimeException("请求没有被送达ProceedHandler");
        }
    }
}
