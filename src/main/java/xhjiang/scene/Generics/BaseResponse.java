package xhjiang.scene.Generics;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @description: 基础响应类
 * @author: xhjiang
 * @date: 2025/4/2 11:41
 */
@Getter
@Setter
@AllArgsConstructor
public class BaseResponse<T> {
    private T data;
    private String name;
    private Integer age;

    public <R> R processData(java.util.function.Function<T,R> processor){
        //函数式接口
        return processor.apply(data);
    }
}
