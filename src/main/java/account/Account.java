package account;

/**
 * 账户类
 * @author zhenye 2018/4/12
 */
public class Account {

    private int money;
    Account(int money){
        this.money = money;
    }

    /**
     * 向账户中存钱
     * @param money 存钱金额为money
     */
    public synchronized void saveMoney(int money){
        this.money=this.money+money;
        System.out.println("新存入："+money+" 共计："+this.money);
        notify();
    }

    /**
     * 从账户中取钱
     * @param money 取钱金额为money
     */
    public synchronized void takeMoney(int money){
        //注意这个地方必须用while循环，因为即便再存入钱也有可能比取的要少
        while(this.money<money){
            System.out.println("取款："+money+" 余额："+this.money+" 余额不足，正在等待存款......");
            try{ wait();} catch(Exception e){}
        }
        this.money=this.money-money;
        System.out.println("取出："+money+" 还剩余："+this.money);
    }
}
