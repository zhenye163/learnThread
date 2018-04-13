package food;

/**
 * 记录每个顾客的信息Guest
 * @author zhenye 2018/4/12
 */
public class Guest implements Runnable {
    // 对于这三个顾客而言，盘子中的食物是共享资源。static修饰！！！
    public static Dish dish;
    // 顾客名称
    private String name;
    // 该顾客吃一个食物的耗时
    private long time;
    // 统计每个顾客吃了多少食物，初始值为0
    private int count = 0;

    Guest (String name, long time) {
        this.name = name;
        this.time = time;
    }

    // 场景还原
    public void run() {
        while (true) {
            if (canGetFood()) {
                eat();
            }else {
                System.out.println( this.name + "想从盘子中拿"+dish.getFoodName()  +"吃，发现已经盘子中已经没有了,总共吃了" + this.count + "个" + dish.getFoodName());
                return;
            }
        }
    }

    // 这个方法必须是同步方法！！！同一时刻只能有一个人从盘子中拿食物。
    private static synchronized  boolean canGetFood () {
        boolean result = dish.getNum() > 0;
        if (result) {
            dish.setNum(dish.getNum() - 1);
            System.out.println( Thread.currentThread().getName() + "拿出一个"+dish.getFoodName() +"后，此时盘子中还剩下" + dish.getNum() + "个。");
        }
        return result;
    }

    // 模拟顾客拿到食物后的进食时间
    private void eat() {
        try {
            Thread.sleep(this.time);
            this.count++;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
