package design_patterns.state;

/**
 * @Description
 * @Date 2024/4/17 10:27
 */
public class User {
    private UserState userState;
    private String uname;

    public User(String uname) {
        this.uname = uname;
        //游客
        this.userState = new GuestState(this);
        this.userState.setUser(this);
    }

    public void register() {
        this.userState = new MemberState(this);
        this.userState.setUser(this);
    }

    public void openVIP() {
        this.userState = new VipState(this);
        this.userState.setUser(this);
    }

    public void play4K() throws Exception {
        userState.play4K();
    }

    public void play720P() {
        userState.play720P();

    }

    public void play1080P() {
        userState.play1080P();
    }
}
