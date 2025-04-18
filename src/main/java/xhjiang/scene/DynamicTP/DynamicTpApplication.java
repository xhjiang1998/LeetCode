package xhjiang.scene.DynamicTP;

import org.dromara.dynamictp.core.spring.EnableDynamicTp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @description: web启动类
 * @author: xhjiang
 * @date: 2025/4/11 23:38
 */
@SpringBootApplication
@EnableDynamicTp
public class DynamicTpApplication {
    public static void main(String[] args){
        SpringApplication.run(DynamicTpApplication.class,args);
    }
}
