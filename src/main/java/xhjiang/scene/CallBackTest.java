package xhjiang.scene;

import xhjiang.scene.api.CallBack;

/**
 * @description: 回调方法测试
 * @author: xhjiang
 * @date: 2025/3/3 11:08
 * @description: 手写模拟一个回调方法
 */
public class CallBackTest {
    public static void main(String[] args) {
        CallBackTest test=new CallBackTest();
        test.useCallback(new CallBack() {
            @Override
            public void callBack() {
                System.out.println("callback method is used for printing……");
            }
        });
    }
    public void useCallback(CallBack callBack){
        callBack.callBack();
        System.out.println("call back in useCallBack");
    }
}
