package design_patterns.Bridge;

import design_patterns.Bridge.logger.Log4jLogger;
import design_patterns.Bridge.logger.LogbackLogger;
import design_patterns.Bridge.service.EmployService;
import design_patterns.Bridge.service.UserService;
import design_patterns.Bridge.writer.MongoOperator;
import design_patterns.Bridge.writer.MysqlOperator;

/**
 * @Description
 * @Date 2024/4/15 20:26
 */
public class Client {
    public static void main(String[] args) {
        EmployService employService = new EmployService(new LogbackLogger(),new MysqlOperator());
        employService.init();
        System.out.println("------------");
        UserService userService = new UserService(new Log4jLogger(),new MongoOperator());
        userService.init();
    }

}
