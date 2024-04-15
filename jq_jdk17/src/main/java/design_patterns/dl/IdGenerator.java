package design_patterns.dl;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @Description
 * @Date 2024/4/8 22:27
 */
public class IdGenerator {
    private AtomicLong id=new AtomicLong();
    private IdGenerator() {

    }
    private static class SingletonHolder{
        private static final IdGenerator instance=new IdGenerator();
    }
    public static IdGenerator getInstance(){
        return SingletonHolder.instance;
    }
    public long getId(){
        return id.incrementAndGet();
    }
}
