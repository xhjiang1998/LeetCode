package xhjiang.scene.DynamicTP;

import cn.hutool.core.thread.ConcurrencyTester;
import cn.hutool.core.thread.ThreadUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description: 测试动态线程池的页面请求层
 * @author: xhjiang
 * @date: 2025/4/11 20:30
 */
@RestController
@Slf4j
@RequestMapping("/xhjiang")
public class TestController {
    @Resource
    private RegService regService;
    @GetMapping("/notify")
    public void testReg(){
        ConcurrencyTester tester= ThreadUtil.concurrencyTest(200,()->{
            //1、执行挂号
            regService.execute();

            //2、异步统计挂号量
            regService.statisticAsync();

            //3、回写操作
            regService.writeBack();
        });
    }
}
