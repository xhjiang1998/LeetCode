package xhjiang.scene.DesignModel.SimpleFactory;

/**
 * @description: 简单工厂模式
 * @author: xhjiang
 * @date: 2025/2/26 10:38
 * @description: 由一个工厂类（通常是静态方法）根据传入参数创建不同的产品实例
 * @version: 2.0
 */
public class FactroyModel {
    public static void main(String[] args){
        Product product=Factory.createProduct("car");
        product.productEffect();
    }
}
