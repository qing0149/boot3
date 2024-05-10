package design_patterns.Bridge.writer;

/**
 * @Description
 * @Date 2024/4/15 20:12
 */
public class MysqlOperator implements DbOperator{

    @Override
    public void insert(Object obj) {
        System.out.println("MysqlOperator:"+obj);
    }
}