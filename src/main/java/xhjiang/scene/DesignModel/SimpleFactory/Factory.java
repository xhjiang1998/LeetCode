package xhjiang.scene.DesignModel.SimpleFactory;

/**
 * @description: 工厂类
 * @author: xhjiang
 * @date: 2025/2/26 10:21
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
