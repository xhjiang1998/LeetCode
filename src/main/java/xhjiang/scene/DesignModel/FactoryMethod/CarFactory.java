package xhjiang.scene.DesignModel.FactoryMethod;

/**
 * @description: 产品：车
 * @author: xhjiang
 * @date: 2025/2/26 10:24
 */
public class CarFactory implements AbstractFactory {
    @Override
    public void createProduct() {
        System.out.println("CarFactory create Car！");
    }
}
