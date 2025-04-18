package xhjiang.scene.Test.Model;

import com.alibaba.fastjson.JSON;

/**
 * @description: 用来测试通知类模型初始化是否会给字段赋值的
 * @author: xhjiang
 * @date: 2025/4/14 16:33
 */
public class NotifyTest {
    public static void main(String[] args) {
        NotifyTest notifyTest=new NotifyTest();
        NotifyModel notifyModel=new NotifyModel("test");
        System.out.println(JSON.toJSONString(notifyModel));
        notifyModel=notifyTest.calAmount(notifyModel);
        System.out.println(JSON.toJSONString(notifyModel));
    }
    public NotifyModel calAmount(NotifyModel notifyModel){
        notifyModel.setApplyAmt(1000L);
        return notifyModel;
    }
}
