package design_patterns.state;

/**
 * @Description
 * @Date 2024/4/17 10:45
 */
public class GuestState extends UserState{

    public GuestState(User user) {
        super(user);
    }

    @Override
    public void play4K() throws Exception {
        System.out.println("输出4k");
        throw new Exception("禁止输出4k");

    }

    @Override
    public void play720P() {
        System.out.println("输出720p");
    }

    @Override
    public void play1080P() {
        System.out.println("输出1080p");
    }
}
