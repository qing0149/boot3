package design_patterns.Mediator;

/**
 * @Description
 * @Date 2024/4/16 16:06
 */
public abstract class User {
    protected String name;

    public User(String name) {
        this.name = name;
    }
    protected ChatMediator mediator;

    public User(ChatMediator mediator) {
        this.mediator = mediator;
    }
    public abstract void sendMessage(String message);
    public abstract void receiveMessage(String message);

}
