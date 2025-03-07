package xhjiang.scene.DesignModel.ShoppingCart;

import java.sql.SQLOutput;

/**
 * @description: 微信支付
 * @author: xhjiang
 * @date: 2025/2/26 14:08
 */
public class WechatPay implements Payment{
    private String wechatNumber;
    private String phoneNumber;
    private String code;
    public WechatPay(String wechatNumber, String phoneNumber, String code) {
        this.wechatNumber = wechatNumber;
        this.phoneNumber = phoneNumber;
        this.code = code;
    }

    @Override
    public boolean pay(double price) {
        System.out.println("Wechatnumber"+wechatNumber+"paid RMB"+price);
        return true;
    }
}
