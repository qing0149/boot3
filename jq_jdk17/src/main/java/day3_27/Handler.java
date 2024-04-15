package day3_27;

import java.util.Map;
import java.util.Objects;

/**
 * @Description
 * @Date 2024/3/27 19:20
 */
public interface Handler {
    public void setNext(Handler handler);

    public void handler(Map<String, Object> map);
}
