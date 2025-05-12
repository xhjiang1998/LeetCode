package xhjiang.blibli.spring.itheima;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.DefaultSingletonBeanRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import xhjiang.scene.DynamicTP.DynamicTpApplication;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * 哔哩哔哩的Spring原理项目，主要学习用于动态线程池的基础
 * @author: xhjiang
 * @date: 2025/5/12 15:59
 */
@SpringBootApplication
@ComponentScan("xhjiang.scene.DynamicTP")
public class A01Application {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        ConfigurableApplicationContext context = SpringApplication.run(A01Application.class, args);

        // 该属性为父类DefaultSingletonBeanRegistry的成员变量
        Field singletonObjects =
                DefaultSingletonBeanRegistry.class.getDeclaredField(
                        "singletonObjects");

        singletonObjects.setAccessible(true);
        //这里为什么不用36行呢？因为方法的返回就是这个ConfigurableListableBeanFactory类型
        ConfigurableListableBeanFactory beanFactory= context.getBeanFactory();
//        BeanDefinitionRegistry beanFactory=context.getBeanFactory();

        //通过反射获取Field字段的值
        Map<String, Object> stringObjectMap = (Map<String, Object>) singletonObjects.get(beanFactory);

        stringObjectMap.entrySet().stream().filter(e->e.getKey().startsWith(
                "regService")).forEach(e->{
            System.out.println(e.getKey()+"="+e.getValue());
        });

    }
}
