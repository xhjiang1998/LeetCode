package xhjiang.scene.Test.StreamTest;

import java.util.List;

/**
 * @description: java8流写法测试
 * @author: xhjiang
 * @date: 2025/3/31 11:21
 */
public class StreamTest {
    public static void main(String[] args) {
        List<String> bizNoList=null;
        bizNoList.stream().filter(bizNo -> bizNo.length() > 0).forEach(System.out::println);
        System.out.println("hello world");
    }
}
