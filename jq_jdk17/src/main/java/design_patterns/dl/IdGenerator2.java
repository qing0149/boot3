package design_patterns.dl;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @Description:枚举对象是单例，一种对象只能在内存保存一份
 * @Date 2024/4/8 22:31
 */
public enum IdGenerator2 {
    INSTANCE;;
    /*   private static final AtomicLong id = new AtomicLong();
        public static long getId() {
            return id.incrementAndGet();
        }*/
    private final AtomicLong id = new AtomicLong();

    public long getId() {
        return id.incrementAndGet();
    }
}
