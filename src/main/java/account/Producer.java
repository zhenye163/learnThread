package account;

/**
 * 向账户中存款的类
 * @author zhenye 2018/4/12
 */
public class Producer implements Runnable{
    Account account;
    Producer(Account account) {
        this.account = account;
    }

    public void run() {
        while (true) {
            int num = (int)(Math.random()*1000);
            account.saveMoney(num);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
