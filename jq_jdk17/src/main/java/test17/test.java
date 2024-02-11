package test17;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.Week;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Stream;

/**
 * @program: Boot3
 * @description:
 * @author:
 * @create: 2024-01-26 01:38
 **/
public class test {

    @Test
    public void test1() {
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
//        set.add(2);
//        set.add(2);
//        set.add(3);
        System.out.println(set);
        boolean remove = set.remove(1);
        System.out.println(set);
        System.out.println(set.size());
    }

    @Test
    public void test2() {
        // 输入的时间节点
        String inputDate = "2024-01-29";

        // 将输入的时间节点转换为日期对象
        Date date = DateUtil.parse(inputDate);

        // 获取时间节点所在的自然周范围
        //周末
        int i = DateUtil.weekOfYear(date);
        System.out.println(i);
        DateTime dateTime = DateUtil.beginOfWeek(date);
        DateTime dateTime1 = DateUtil.endOfWeek(date);
        System.out.println(dateTime);
        System.out.println(dateTime1);
        //月的范围
        DateTime dateTime2 = DateUtil.beginOfMonth(date);
        DateTime dateTime3 = DateUtil.endOfMonth(date);
        System.out.println(dateTime2);
        System.out.println(dateTime3);
        //年的范围
        DateTime dateTime4 = DateUtil.beginOfYear(date);
        DateTime dateTime5 = DateUtil.endOfYear(date);
        System.out.println(dateTime4);
        System.out.println(dateTime5);
    }

    @Data
    @AllArgsConstructor
    private static class CartOrder {

        private Long deptId;

        private BigDecimal currentDeptPoints;
    }

    @Test
    public void test3() {
        List<CartOrder> cartOrderList = Arrays.asList(
                new CartOrder(1L, new BigDecimal("10.5")),
                new CartOrder(2L, new BigDecimal("20.5")),
                new CartOrder(3L, new BigDecimal("30.5"))
        );

        BigDecimal sum = cartOrderList.stream().map(CartOrder::getCurrentDeptPoints)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("Sum of currentDeptPoints: " + sum);
    }
    @Test
    public void test4() {
        HashMap<String, List<String>> map = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();
        list.add("1234");
        List<String> orDefault = map.getOrDefault("123", list);
        System.out.println(orDefault);
        List<String> orDefault1 = map.getOrDefault("124", list);
        System.out.println(orDefault1);

    }
}
