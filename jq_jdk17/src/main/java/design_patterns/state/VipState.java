package design_patterns.state;

/**
 * @Description
 * @Date 2024/4/17 11:07
 */
public class VipState extends UserState{


    public VipState(User user) {
        super(user);
    }

    @Override
    public void play4K() {

    }

    @Override
    public void play720P() {

    }

    @Override
    public void play1080P() {

    }
}
