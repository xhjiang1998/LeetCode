package xhjiang.scene.Test.Lock;

import redis.clients.jedis.Jedis;

/**
 * @description: 使用redis实现一个分布式锁
 * @author: xhjiang
 * @date: 2025/2/24 18:51
 *
 */
public class DistributedLock {
    private Jedis jedis;
    private String lockKey;
    private String lockValue;
    //锁的超时时间
    private int expireTime;

    public DistributedLock(Jedis jedis,String lockKey,String lockValue,
                           int expireTime){
        this.jedis=jedis;
        this.lockKey=lockKey;
        this.lockValue=lockValue;
        this.expireTime=expireTime;
    }

    public boolean lock(){
        long res=jedis.setnx(lockKey,lockValue);
        // 0表示获取到锁
        if (res==0){
            return true;
        }else {
            return false;
        }
    }

    public void unlock(){
        String script="if redis.call('get',KEYS[1]==ARGS[1] then return redis" +
                ".call('del', KEYS[1]) else return 0 end)";
        jedis.eval(script, 1, lockKey, lockValue);
    }

    public static void main(String [] args){
        Jedis jedis=new Jedis("127.0.0.1",6379);
        DistributedLock lock=new DistributedLock(jedis,"lock","123456",10);
        if(lock.lock()){
            try {
                System.out.println("获取锁成功");
                Thread.sleep(1000);
            }catch (Exception e){
                System.out.println(e);
            }finally {
                lock.unlock();
            }
        }else {
            System.out.println("获取锁失败");
        }
    }

}
