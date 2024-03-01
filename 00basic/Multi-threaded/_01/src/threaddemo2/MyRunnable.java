package threaddemo2;

public class MyRunnable implements Runnable{
    @Override
    public void run() {
        //线程启动后执行的代码
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "第二种方式实现多线程" + i);
        }
    }
}
