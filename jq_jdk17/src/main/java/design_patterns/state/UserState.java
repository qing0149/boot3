package design_patterns.state;



/**
 * @Description
 * @Date 2024/4/17 10:25
 */
public abstract class UserState {
    protected User user;

    public UserState(User user) {
        this.user = user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    public abstract void play4K() throws Exception;
    public abstract void play720P();
    public abstract void play1080P();
}
