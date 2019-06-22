package sxt;

/**
 * @author fly
 * @date 2019/5/29
 */
public class Web12306 implements Runnable {
    private int ticket = 100;
    @Override
    public void run() {
        while (true){
            if (ticket<0){
                break;
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"==>"+ticket--);
        }
    }

    public static void main(String[] args) {
        Web12306 web = new Web12306();
        System.out.println(Thread.currentThread().getName());
        new Thread(web,"A").start();
        new Thread(web,"B").start();
        new Thread(web,"C").start();
    }
}
