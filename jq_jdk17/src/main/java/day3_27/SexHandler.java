package day3_27;

import java.util.Map;

/**
 * @Description
 * @Date 2024/3/27 19:42
 */
public class SexHandler extends AbstractHandler {

    @Override
    public void handler(Map<String, Object> map) {
        System.out.println("=========性别拦截器开始==========");
        Object o = map.get("sex");
        Integer sex = (Integer) o;
        if (0 == sex) {
            System.out.println("这是女生");
        }
        if (1 == sex) {
            System.out.println("这是男的");
        }
        if (null != super.getNext()) {
            super.getNext().handler(map);
        }else {
            System.out.println("============拦截终止===========");
        }
        System.out.println("=========性别拦截器结束==========");
    }
}
