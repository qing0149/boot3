package design_patterns.chain;

import javax.net.ssl.HandshakeCompletedEvent;

/**
 * @program: Boot3
 * @description:
 * @author:
 * @create: 2024-03-08 14:07
 **/
public abstract class AbstractHandler implements Handler {
    private Handler next;
    public void setNext(Handler next) {
        this.next = next;
    }
    public Handler getNext() {
        return next;
    }

}
