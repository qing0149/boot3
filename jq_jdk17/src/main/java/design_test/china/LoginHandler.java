package design_test.china;

import cn.hutool.core.util.ObjectUtil;

import java.util.Map;

/**
 * @Description
 * @Date 2024/3/26 20:14
 */
public class LoginHandler extends AbstractHandler {

    @Override
    public void handler(Map<String, Object> map) {
        System.out.println("===LoginHandler处理===");
        String name = (String) map.get("name");
        if (name.equals("admin")) {
            System.out.println("-----名字正确-------");
            Handler next = this.getNext();
            if (ObjectUtil.isNotNull(next)) {
                next.handler(map);
            } else {
                System.out.println("----LoginHandler处理结束------");
            }
        }


    }
}
