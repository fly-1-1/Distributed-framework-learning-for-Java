package threaddemo9;

public class Ticket implements Runnable {
    //票的数量
    private int ticket = 100;
    private Object obj = new Object();

    @Override
    public void run() {
        while(true){
            synchronized (obj){//多个线程必须使用同一把锁.
                if(ticket <= 0){
                    //卖完了
                    break;
                }else{
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    ticket--;
                    System.out.println(Thread.currentThread().getName() + "在卖票,还剩下" + ticket + "张票");
                }
            }
        }
    }
}
