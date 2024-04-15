package design_patterns.Bridge.logger;

/**
 * @Description
 * @Date 2024/4/15 20:14
 */
public class Log4jLogger implements Logger{

    @Override
    public void info(String message) {
        System.out.println("Log4jLogger:"+message);
    }

    @Override
    public void debug(String debug) {
        System.out.println("Log4jLogger:"+debug);
    }
}
