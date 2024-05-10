package SpringCglib;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import org.junit.Test;

/**
 * @Description
 * @Date 2024/4/25 10:36
 */
public class test {
    @Test
    public void testCglibProxy() {
        SuperSatZhou superStar = new SuperSatZhou();
        System.out.println("代理前类型" + superStar.getClass());
        SuperSatZhou proxy = (SuperSatZhou)
                new CGLibProxyFactory(superStar).getProxyInstance();
        System.out.println("代理后类型" + proxy.getClass());
        proxy.sing();
    }
    @Test
    public void testCglibProxy1() {
        SuperSatZhou superStar = new SuperSatZhou();
        System.out.println("代理前类型" + superStar.getClass());
        SuperSatZhou proxy = (SuperSatZhou)
                new CGLibProxyFactory(superStar).getProxyInstance();
        System.out.println("代理后类型" + proxy.getClass());
        proxy.xizao();
    }
    @Test
    public void testCglibProxy2() {
        SuperSatZhou superStar = new SuperSatZhou();
//        System.out.println("代理前类型" + superStar.getClass());
        SuperSatZhou proxy = (SuperSatZhou)
                new CGLibProxyFactory(superStar).getProxyInstance();
//        System.out.println("代理后类型" + proxy.getClass());
        proxy.getNumber();
    }
    @Test
    public void testDate(){
        DateTime dateTime = new DateTime();
        DateTime offset = new DateTime().offset(DateField.DAY_OF_MONTH, 30);
        System.out.println(dateTime);
        System.out.println(offset);

    }
}
