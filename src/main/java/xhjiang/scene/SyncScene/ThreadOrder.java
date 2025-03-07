package xhjiang.scene.SyncScene;

/**
 * @description: 考察线程有序执行
 * @author: xhjiang
 * @date: 2025/3/3 16:13
 * @description: 三个线程按照顺序打印从0到100
 */
public class ThreadOrder {
    public static synchronized void countAmount(){
        for(int i=0;i<100;i++){
            System.out.println(Thread.currentThread().getName()+" "+i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1=new MyThread();
        Thread thread2=new MyThread();
        Thread thread3=new MyThread();
        thread1.start();
        thread1.join();
        thread2.start();
        thread2.join();
        thread3.start();
        thread3.join();
    }

    static class MyThread extends Thread{
        public void run(){
            countAmount();
        }
    }

}
