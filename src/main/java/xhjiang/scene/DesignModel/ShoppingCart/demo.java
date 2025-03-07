package xhjiang.scene.DesignModel.ShoppingCart;

/**
 * @description: 主类
 * @author: xhjiang
 * @date: 2025/2/26 14:12
 * @description：
 * 题目：购物车
 * a. 实现一个商品类，包括商品的名称和价格。
 * b. 实现一个购物车ShoppingCart，其中主要包含商品类的集合，以及添加商品、计算总价、支付等方法；要求购物车实例全局唯一。
 * c. 支持不同的支付方式，包括支付宝、微信、信用卡。其中
 * 1） 支付宝支付必须知道用户的电子邮箱，支付密码和支付金额；
 * 2） 微信支付必须知道用户的微信号，手机号码，验证码和支付金额；
 * 3） 信用卡支付必须知道银行账号，密码，信用卡有效期和支付金额；
 * 4） 需要在不同的支付方式中打印不同内容；
 * 如：“Wechat Number ABC123 paid RMB 100.”
 * d. 用合适的设计模式实现支付方式，方便扩展。
 */
public class demo {
    public static void main(String[] args) {
        //商品
        Goods eggs=new Goods("eggs",10);
        Goods milk=new Goods("milk",20);

        //初始化并添加购物车
        ShoppingCart cart=ShoppingCart.getShoppingCart();
        cart.addGoods(eggs);
        cart.addGoods(milk);
        //计算总价
        cart.getTotalPrice();

        //支付
        Payment payment=new WechatPay("xhjiang1999","18851982061","Cupdata123");
        cart.checkOut(payment);

        ShoppingCart cart2=ShoppingCart.getShoppingCart();
        cart2.addGoods(eggs);
        cart2.getTotalPrice();
    }
}
