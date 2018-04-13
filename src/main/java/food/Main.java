package food;

/**
 * 多线程场景还原的测试类
 * @author zhenye 2018/4/12
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("场景模拟开始：");
        // 进来了三个顾客：张三，李四，王五
        Guest guest1 = new Guest("张三",2000L);
        Guest guest2 = new Guest("李四",3000L);
        Guest guest3 = new Guest("王五",4000L);

        // 他们点了盘菜：10个包子
        Dish dish = new Dish("包子",10);
        Guest.dish = dish;

        Thread t1 = new Thread(guest1);
       t1.setName("张三");
        Thread t2 = new Thread(guest2);
        t2.setName("李四");
        Thread t3 = new Thread(guest3);
        t3.setName("王五");

        // start()方法启动三个线程，保证三个线程在同时运行
        t1.start();
        t2.start();
        t3.start();

        // 当前线程是main,等t1,t2,t3三个线程都处于DEAD状态后，再继续执行之后的代码。
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("场景模拟结束！");
    }
}
