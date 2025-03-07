package xhjiang.scene.DesignModel.FactoryMethod;

/**
 * @description: 手机工厂类
 * @author: xhjiang
 * @date: 2025/3/3 16:02
 */
public class PhoneFactory implements AbstractFactory{
    @Override
    public void createProduct() {
        System.out.println("生产手机");
    }
}
