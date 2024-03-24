package design_patterns.chain;

import java.util.Map;

/**
 * @ClassName Handler
 * @Description
 * @Author
 * @Date 2024/3/8 14:06
 * @Version 1.0
 */
public interface Handler {
    void setNext(Handler next);

    void handle(Map<String, Object> request);
}
