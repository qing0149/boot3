package design_patterns.TemplateMethod;

import cn.hutool.core.util.StrUtil;

import java.util.Arrays;

/**
 * @Description
 * @Date 2024/4/16 16:36
 */
public class Facebook extends Network {
    @Override
    boolean logIn(String userName, String password) {
        if (!StrUtil.isAllBlank(userName, password)) {
            System.out.println("facebook登录成功");
            return true;
        }else {
            System.out.println("facebook登录失败");
            return false;
        }
    }

    @Override
    boolean sendData(byte[] data) {
        String s = String.valueOf(data);
        System.out.println("发送消息"+s);
        return false;
    }

    @Override
    void logOut() {
        System.out.println("退出登录");
    }
}
