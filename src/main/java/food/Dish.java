package food;

/**
 * 盘子中记录的是此时其中还有num个foodName
 * @author zhenye 2018/4/12
 */
public class Dish {
    // 食物名称
    private String foodName;
    // 食物数目
    private int  num;

    Dish(String foodName, int num){
        this.foodName = foodName;
        this.num = num;
    }

    public String getFoodName(){
        return this.foodName;
    }

    public void setFoodName (String foodName) {
        this.foodName = foodName;
    }

    public int getNum() {
        return this.num;
    }

    public void setNum (int num) {
        this.num = num;
    }
}
