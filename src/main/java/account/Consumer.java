package account;

/**
 * 从账户中取款的类
 * @author zhenye 2018/4/12
 */
public class Consumer implements Runnable{
    Account account;
    Consumer (Account account) {
        this.account = account;
    }

    public void run() {
        while (true) {
            int num = (int) (Math.random() * 1000);
            account.takeMoney(num);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
