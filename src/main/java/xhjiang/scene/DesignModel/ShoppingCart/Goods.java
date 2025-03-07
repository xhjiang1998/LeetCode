package xhjiang.scene.DesignModel.ShoppingCart;

/**
 * @description: 商品
 * @author: xhjiang
 * @date: 2025/2/26 13:57
 */
public class Goods {
    private  String name;
    private  double price;

    public Goods(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
}
