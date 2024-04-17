package design_patterns.TemplateMethod;

/**
 * @Description
 * @Date 2024/4/17 11:53
 */
public class Client {
    public static void main(String[] args) {
        Network facebook = new Facebook();
        facebook.userName="张三";
        facebook.password="123456";
        boolean flag = facebook.post("ssss");
        System.out.println(flag);
    }

}
