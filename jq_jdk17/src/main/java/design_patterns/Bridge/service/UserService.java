package design_patterns.Bridge.service;

import design_patterns.Bridge.logger.Logger;
import design_patterns.Bridge.writer.DbOperator;

/**
 * @Description
 * @Date 2024/4/15 20:18
 */
public class UserService implements Service {
    private Logger logger = null;
    private DbOperator dbOperator=null;

    public UserService(Logger logger, DbOperator dbOperator) {
        this.logger = logger;
        this.dbOperator = dbOperator;
    }
    public void update() {
        System.out.println("UserService,update");
    }
    @Override
    public void init() {
        dbOperator.insert("UserService");
        logger.info("UserService");

    }
}
