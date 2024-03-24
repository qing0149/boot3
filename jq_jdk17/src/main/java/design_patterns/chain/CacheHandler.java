package design_patterns.chain;

import java.util.Map;

/**
 * @program: Boot3
 * @description:
 * @author:
 * @create: 2024-03-08 14:21
 **/
public class CacheHandler extends AbstractHandler {

    @Override
    public void handle(Map<String, Object> request) {
        System.out.println("已将当前求转存到Redis缓存");
        if (this.getNext()!=null){
            this.getNext().handle(request);
        }else {
            throw new RuntimeException("请求没有被送达ProceedHandler");
        }
    }
}
