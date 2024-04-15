package day3_27;

/**
 * @Description
 * @Date 2024/3/27 19:41
 */
public abstract class AbstractHandler implements Handler{
    private Handler next;

    @Override
    public void setNext(Handler handler) {
        this.next=handler;
    }

    public Handler getNext() {
        return next;
    }
}
