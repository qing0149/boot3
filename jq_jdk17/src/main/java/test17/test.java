package test17;

import org.junit.Test;

import java.util.HashSet;

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
}
