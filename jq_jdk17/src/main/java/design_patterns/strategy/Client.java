package design_patterns.strategy;

import java.util.Scanner;

/**
 * @Description
 * @Date 2024/3/27 20:21
 */
public class Client {
    public static void main(String[] args) {
//        最重要在命令的时候决定运行的是谁
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        UserDao dao = null;
        switch (input) {
            case "jdbc":
                dao = new JdbcDao();
            case "odbc":
                dao = new OdbcDao();
            case "jndi":
                dao = new JndiDao();
        }
        UserService userService = new UserService(dao);
        userService.createUser();

    }

}
