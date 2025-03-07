package xhjiang.scene.DesignModel.ShoppingCart;

/**
 * @description: 支付接口
 * @author: xhjiang
 * @date: 2025/2/26 14:07
 * @description: 这里采用工厂方法模式，这样新增支付方式就不用修改代码，只需要新增一个类实现Payment接口即可
 */
public interface Payment {
    boolean pay(double price);
}
