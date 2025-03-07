package xhjiang.scene.SyncScene;

import java.util.concurrent.CountDownLatch;

/**
 * @description: countdownlatch的使用
 * @author: xhjiang
 * @date: 2025/2/28 10:41
 * https://blog.csdn.net/u011441473/article/details/103072449
 */
public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch begin=new CountDownLatch(1);
        CountDownLatch end=new CountDownLatch(3);
        begin.countDown();
        System.out.println("race is starting……");
        for(int i=0;i<3;i++){
            Thread myThread=new Thread(new Player(begin,end));
            myThread.start();
//            begin.countDown();
//            end.await();
//            System.out.println("race is end……");
        }
        end.await();
        System.out.println("race is end……");
    }
    static class Player extends Thread{
        private CountDownLatch begin;
        private CountDownLatch end;
        public Player(CountDownLatch begin,CountDownLatch end){
            this.begin=begin;
            this.end=end;
        }
        public void run(){
            try{
                begin.await();
                System.out.println(Thread.currentThread()+"is arrived");
                end.countDown();
            }catch (Exception e){
                System.out.println(e);
            }
        }
    }
}
