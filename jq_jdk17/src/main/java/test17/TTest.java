package test17;

/**
 * @Description
 * @Date 2024/4/25 10:05
 */
public class TTest {
    public static void main(String[] args) {
        Student student = new Student();
        student.setId(null);
        Student proxy = NotNullCheckProxy.createProxy(student);
        try {
            Long id = student.getId();
            System.out.println("Id: " + id);
        } catch (RuntimeException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

}
