package xhjiang.scene.DesignModel.SimpleFactory;

/**
 * 产品：车
 *
 * @author: xhjiang
 * @date: 2025/2/26 10:24
 */
public class Car implements Product{
    @Override
    public void productEffect() {
        System.out.println("i can use this product to drive");
    }
}
