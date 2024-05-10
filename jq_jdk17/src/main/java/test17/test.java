package test17;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.Week;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.logging.SimpleFormatter;
import java.util.stream.Collectors;
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

    @Test
    public void test5() {
        String fileName = "新建 文本文档 (2).txt";
        int newFileNamePointPosition = fileName.lastIndexOf(".");
        System.out.println(newFileNamePointPosition);
    }

    @Test
    public void test6() {
        List<Integer> list = Arrays.asList(null, null, 2);
//        boolean allEmpty = ObjectUtil.isNotEmpty(list.get(0), list.get(1));
 /*       ObjectUtil.
        System.out.println(allEmpty)*/
        ;

    }

    @Test
    public void test7() throws ParseException {
        String date1 = "2023-09-01 12:01:03";
        Date date2024 = new Date();
        System.out.println("------" + date2024);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date2023 = format.parse(date1);
        boolean before = date2023.before(date2024);
        System.out.println("------" + before);

    }

    @Test
    public void test8() throws ParseException, InterruptedException {
        Date date1 = new Date();
        Date clone = (Date) date1.clone();
        System.out.println(date1);
        Thread.sleep(500);
        Date date2 = new Date();
        System.out.println(date2);
        int i = date1.compareTo(date2);
        System.out.println(i);
        int i1 = date1.compareTo(clone);
        System.out.println(i1);
    }

    @Test
    public void test9() throws InterruptedException {
        ArrayList<Integer> ids = new ArrayList<>();
        ids.add(0);
        ids.add(0);
        ids.add(0);
        ids.add(0);
        ids.add(0);
        System.out.println(ids);
//        Integer remove = ids.stream().reduce()
//        System.out.println(remove);
        System.out.println(ids);

    }

    @Test
    public void test10() throws InterruptedException {
        HashSet<Integer> ids = new HashSet<>();
        ids.add(0);
        ids.add(0);
        ids.add(0);
        ids.add(0);
        ids.add(0);
        System.out.println(ids);
        boolean remove = ids.remove(0);
//        System.out.println(remove);
        System.out.println(ids);
        if (CollUtil.isEmpty(ids)) {
            System.out.println("sss");
        }

    }

    @Test
    public void test11() throws InterruptedException {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        List<Integer> integers = list.subList(0, 1);
        System.out.println(integers);

    }

    @Test
    public void test12() throws InterruptedException {
//        String day1 = "2024-04-13 10:35:24";
//        String day2 = "2024-04-15 10:35:24";
        String day1 = "2024-04-13 10:35:24";
        String day2 = "2024-04-15 10:35:24";
/*        LocalDateTime startDate = LocalDateTime.parse(day1);
        LocalDateTime endDate = LocalDateTime.parse(day2);*/
        LocalDateTime startDate = LocalDateTime.parse(day1);
        LocalDateTime endDate = LocalDateTime.parse(day2);
        LocalDateTime currentDate = LocalDateTime.now(); // 获取当前日期
        boolean isBetween = !currentDate.isBefore(startDate) && !currentDate.isAfter(endDate);
        System.out.println("当前日期是否在指定日期区间内：" + isBetween);

    }

    @Test
    public void ttt() {
        String day1 = "2024-04-13 10:35:24";
        String day2 = "2024-04-16 10:35:24";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime startDate = LocalDateTime.parse(day1, formatter);
        LocalDateTime endDate = LocalDateTime.parse(day2, formatter);
        LocalDateTime currentDate = LocalDateTime.now(); // 获取当前日期时间
        boolean isBetween = !currentDate.isBefore(startDate) && !currentDate.isAfter(endDate);
        System.out.println("当前日期时间是否在指定日期时间区间内：" + isBetween);
    }

    @Test
    public void test14() {
//        String day1 = null;
        String day1 = "2024-04-13 10:35:24";
        String day2 = "2024-04-16 10:35:24";
        boolean allBlank = StrUtil.isAllNotBlank(day1, day2);
        System.out.println(allBlank);
    }

    @Test
    public void test15() {
        String day1 = "2024-04-13 10:35:24";
        String day2 = "2024-04-12 10:35:24";
        String day3 = "2024-04-14 10:35:24";
        String day4 = "2024-04-15 10:35:24";
        String day5 = "2024-04-16 10:35:24";
        ArrayList<String> list = new ArrayList<>();
        list.add(day1);
        list.add(day2);
        list.add(day3);
        list.add(day4);
        list.add(day5);
        List<String> collect = list.stream().filter(l -> {
            DateTime parse = DateUtil.parse(l);
            return DateUtil.isSameDay(parse, new Date());
        }).collect(Collectors.toList());
        System.out.println(collect);
    }
    @Test
    public void tst16(){
        Integer a=3;
        if (ObjectUtil.isNull(a)
                || (!ObjectUtil.equals(a, 0)
                || (!ObjectUtil.equals(a, 1)))) {
            System.out.println("sssss");
        }else {
            System.out.println("bbbbbbbbbbbb");
        }
    }
    @Test
    public void tst17(){
//        Student student = new Student();
//        Long id = student.getId();
//        System.out.println(id);

    }
}
