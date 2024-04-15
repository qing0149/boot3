package design_patterns.Bridge.service;

import design_patterns.Bridge.logger.Logger;
import design_patterns.Bridge.writer.DbOperator;

/**
 * @Description
 * @Date 2024/4/15 20:18
 */
public class EmployService implements Service {
    private Logger logger = null;
    private DbOperator dbOperator=null;

    public EmployService(Logger logger, DbOperator dbOperator) {
        this.logger = logger;
        this.dbOperator = dbOperator;
    }
    public void create() {
        System.out.println("EmployService,create逻辑");
    }
    @Override
    public void init() {
        dbOperator.insert("EmployService");
        logger.info("EmployService");
    }
}
