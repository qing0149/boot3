package design_test.china;

import java.util.Map;

/**
 * @Description
 * @Date 2024/3/26 20:06
 */
public interface Handler {
    public void setNext(Handler handler);

    public void handler(Map<String, Object> map);
}
