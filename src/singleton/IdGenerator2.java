package singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 懒汉式：用到的时候再加载
 * synchronzed导致并发度很低，
 * 如果这个单例类偶尔会被用到，那这种实现方式还可以接受。
 * 但是，如果频繁地用到，那频繁加锁、释放锁及并发度低等问题，会导致性能瓶颈，这种实现方式就不可取了。
 */
public class IdGenerator2 {
    private AtomicLong id = new AtomicLong(0);
    private static IdGenerator2 instance;
    private IdGenerator2() {}
    public static synchronized IdGenerator2 getInstance() {
        if (instance == null) {
            instance = new IdGenerator2();
        }
        return instance;
    }
    public long getId() {
        return id.incrementAndGet();
    }
}
