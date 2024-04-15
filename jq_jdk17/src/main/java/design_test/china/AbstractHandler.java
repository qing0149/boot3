package design_test.china;

/**
 * @Description
 * @Date 2024/3/26 20:07
 */
public abstract class AbstractHandler implements Handler {
    private Handler next;

    @Override
    public void setNext(Handler handler) {
        this.next = handler;
    }

    public Handler getNext() {
        return next;
    }
}
