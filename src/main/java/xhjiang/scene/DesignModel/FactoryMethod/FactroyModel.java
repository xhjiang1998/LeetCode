package xhjiang.scene.DesignModel.FactoryMethod;

/**
 * @description: 工厂模式
 * @author: xhjiang
 * @date: 2025/2/26 10:20
 * @description: 将工厂抽象成接口或抽象类，每个具体产品都有一个对应的工厂子类，客户端需要依赖具体的工厂实现。
 */
public class FactroyModel {
    public static void main(String[] args) {
        AbstractFactory factory=new CarFactory();
        factory.createProduct();
        factory=new PhoneFactory();
        factory.createProduct();
    }
}
