package design_patterns.Mediator;

/**
 * @Description
 * @Date 2024/4/16 16:09
 */
public abstract class ChatMediator {
    public abstract void register(User user);

    public abstract void notice(User user, String message);

}
