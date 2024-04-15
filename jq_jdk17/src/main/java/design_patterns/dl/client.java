package design_patterns.dl;

/**
 * @Description
 * @Date 2024/4/8 22:36
 */
public class client {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            long id = IdGenerator2.INSTANCE.getId();
            System.out.println(id);
        }

    }

}
