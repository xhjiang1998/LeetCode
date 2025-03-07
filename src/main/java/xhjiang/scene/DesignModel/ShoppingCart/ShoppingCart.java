package xhjiang.scene.DesignModel.ShoppingCart;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 购物车
 * @author: xhjiang
 * @date: 2025/2/26 14:00
 * @description: 需要保证全局实例唯一
 */
public class ShoppingCart {
    private List<Goods> list;
    private double totalPrice;

    private static volatile ShoppingCart instance;//定义全局唯一实例id，使用volatile
    // 防止指令重排，保障全局可见性

    /**
     *
     * 懒汉式双重检查锁来保障全局唯一
     */
    public static ShoppingCart getShoppingCart(){
        if (instance==null){
            synchronized (ShoppingCart.class){
                if (instance==null){
                    instance=new ShoppingCart();
                }
            }
        }
        return instance;
    }

    /**
     * 构造函数
     */
    private ShoppingCart(){
        list=new ArrayList<Goods>();
    }

    /**
     * 计算总价
     * @return
     */
    public double getTotalPrice(){
        double totalPrice=0;
        for (int i = 0; i < list.size(); i++) {
            totalPrice+=list.get(i).getPrice();
        }
        System.out.println("总价为："+totalPrice);
        return totalPrice;
    }

    /**
     * 添加商品
     * @param good
     */
    public void addGoods(Goods good){
        list.add(good);
    }

    /**
     * 结算商品
     * @return
     */
    public boolean checkOut(Payment payment){
        return payment.pay(getTotalPrice());
    }

    public List<Goods> getList() {
        return list;
    }
    public void setList(List<Goods> list) {
        this.list = list;
    }
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
