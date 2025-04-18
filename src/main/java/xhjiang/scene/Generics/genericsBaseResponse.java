package xhjiang.scene.Generics;

/**
 * @description: 基类继承者
 * @author: xhjiang
 * @date: 2025/4/2 11:48
 */
public class genericsBaseResponse<T> extends BaseResponse<T>{
    //这里的泛型T是类型变量参数，通过这传入到内部具体的变量，确定data的类型
    private String extendField;
    public genericsBaseResponse(T data,String name, Integer age,String extendField) {
        super(data,name, age);
        this.extendField=extendField;
    }
}
