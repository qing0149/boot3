package design_patterns.Bridge.logger;

/**
 * @Description
 * @Date 2024/4/15 20:15
 */
public class LogbackLogger implements Logger{
    @Override
    public void info(String message) {
        System.out.println("LogbackLogger:"+message);
    }

    @Override
    public void debug(String debug) {
        System.out.println("LogbackLogger:"+debug);
    }
}
