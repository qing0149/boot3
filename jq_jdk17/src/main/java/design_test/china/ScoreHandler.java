package design_test.china;

import cn.hutool.core.util.ObjectUtil;

import java.util.Map;

/**
 * @Description
 * @Date 2024/3/26 20:22
 */
public class ScoreHandler extends AbstractHandler {

    @Override
    public void handler(Map<String, Object> map) {
        System.out.println("======ScoreHandler处理开始======");
        Integer score = (Integer) map.get("score");
        if (score < 60) {
            System.out.println("不及格");
        } else {
            System.out.println("及格");
        }
        if (ObjectUtil.isNotNull(super.getNext())) {
            super.getNext().handler(map);
        }
        System.out.println("======ScoreHandler处理结束======");
    }
}
