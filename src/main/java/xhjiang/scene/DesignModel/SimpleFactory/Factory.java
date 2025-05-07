package xhjiang.scene.DesignModel.SimpleFactory;

/**
 * 工厂类
 *
 * @date: 2025/2/26 10:21
 * @author: xhjiang
 */
public class Factory {
    public static Product createProduct(String product) {
        switch (product) {
            case "car":
                return new Car();
            case "phone":
                return new Phone();
        }
        return null;
    }
}
