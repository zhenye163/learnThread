package account;

/**
 * 测试入口
 * @author zhenye 2018/4/12
 */
public class Main {
    public static void main(String[] args) {
        Account account = new Account(0);
        Producer producer = new Producer(account);
        Consumer consumer = new Consumer(account);

        Thread t1 = new Thread(producer);
        t1.start();

        Thread t2 = new Thread(consumer);
        System.out.println(t1.getState());
        System.out.println(t2.getState());
        t2.start();
    }
}
