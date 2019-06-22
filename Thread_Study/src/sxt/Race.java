package sxt;

/**
 * @author fly
 * @date 2019/5/29
 */
public class Race implements Runnable {
    private String winner;

    @Override
    public void run() {
        for (int step=1;step<=100;step++){
            System.out.println(Thread.currentThread().getName()+"==>"+step);
            if (Thread.currentThread().getName().equals("rabbit")&&step%10==0){
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            boolean flag = gameOver(step);
            if (flag){
                break;
            }
        }
    }
    private boolean gameOver(int step){
        if (winner!=null){
            return true;
        }else{
            if (step==100){
                winner = Thread.currentThread().getName();
                System.out.println("winner: "+winner);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Race race = new Race();
        new Thread(race,"tortoise").start();
        new Thread(race,"rabbit").start();
    }
}

