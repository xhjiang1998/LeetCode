package xhjiang.scene;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description: 关于线程的场景题
 * @author: xhjiang
 * @date: 2025/2/21 16:21
 * @description: 实现一个简单的令牌桶算法, 请用代码实现一个基于令牌桶算法的限流器，限制每秒最多处理 100 个请求
 */
public class ThreadTest {
    // 桶的容量
    private final int capacity;
    // 桶每秒新增的令牌数量
    private final int refillRate;
    // 令牌
    private AtomicInteger tokens;
    // 令牌桶更新时间
    private long lastUpdateTime;
    // 定义锁
    public ReentrantLock reentrantLock=new ReentrantLock();

    public ThreadTest(int capacity, int refillRate) {
        this.capacity = capacity;
        this.refillRate = refillRate;
        this.tokens= new AtomicInteger(capacity);
        this.lastUpdateTime=System.currentTimeMillis();
    }

    // 获取令牌
    public boolean acquire() {
        reentrantLock.lock();
        while(true) {
            //往桶内添加令牌，由于上面已经lock了，所以这里添加令牌是安全的
            refillTokens(capacity,refillRate);
            if (tokens.get() > 0) {
                tokens.decrementAndGet();
                System.out.println("request请求使用令牌成功");
                reentrantLock.unlock();
                return true;
            }else {
                reentrantLock.unlock();
                return false;
            }
        }
    }

    // 填充桶内令牌
    public void refillTokens(int capacity, int refillRate){
        long now=System.currentTimeMillis();
        //  每秒添加的令牌数量
        long elseps=(now-lastUpdateTime)/1000;
        int addToken=(int) (elseps*refillRate);
        // 避免超过桶内最大容量
        int updateToken=Math.min(capacity,tokens.get()+addToken);
        tokens.set(updateToken);
        // 上次更新时间赋值为现在
        lastUpdateTime=now;
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadTest rateLimiter = new ThreadTest(100, 100);
        for (int i=1;i<100;i++){
            if (rateLimiter.acquire()){
                System.out.println(String.format("第%s的request处理成功",i));
            }else {
                System.out.println(String.format("第%s的request处理失败",i));
            }
            Thread.sleep(100);
        }

    }


}
