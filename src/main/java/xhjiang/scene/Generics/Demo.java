package xhjiang.scene.Generics;

import com.alibaba.fastjson.JSON;
import redis.clients.jedis.Response;

import java.util.Arrays;
import java.util.List;

/**
 * @description: 泛型的使用demo
 * @author: xhjiang
 * @date: 2025/4/2 11:40
 */
public class Demo {
    //泛型类
    public static <T extends Number> double sum(T a,T b) {
        return a.doubleValue()+b.doubleValue();
    }
    //泛型方法
    public static <T> void printArray(T[] array){
        for (T element:array){
            System.out.println(element);
        }
    }

    public static void main(String[] args) {
        BaseResponse<String> stringBaseResponse=new BaseResponse<>("hello",
                "xhjiang",20);
        BaseResponse<Integer> integerBaseResponse=new BaseResponse<>(42,
                "yuezhao" ,
                18);

        genericsBaseResponse<List<String>> customerResponse=
                new genericsBaseResponse<>(Arrays.asList("A","B","C"),"wxzhu"
                        ,21,"extend");

        Demo demo=new Demo();

        System.out.println(JSON.toJSONString(stringBaseResponse));
        System.out.println(JSON.toJSONString(integerBaseResponse));
        System.out.println(JSON.toJSONString(customerResponse));
    }
}
