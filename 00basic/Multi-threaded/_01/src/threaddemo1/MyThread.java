package threaddemo1;

public class MyThread extends Thread{
    @Override
    public void run() {
        //代码就是线程在开启之后执行的代码
        for (int i = 0; i < 100; i++) {
            System.out.println(this.getName().split("-")[1]+"线程开启了" + i);
        }
    }
}
