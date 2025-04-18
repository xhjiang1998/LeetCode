package xhjiang.scene.DynamicTP;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @description: 挂号服务
 * @author: xhjiang
 * @date: 2025/4/11 23:16
 */
@Slf4j
@Service
public class RegService {
    @Resource
    private ThreadPoolExecutor regExecutor;

    /**
     * 执行挂号
     */
    public void execute() {
        try {
            TimeUnit.MICROSECONDS.sleep(200);
        } catch (InterruptedException e) {
            log.error(e.getMessage(), e);
        }
        log.debug(">>>>>>>>>执行挂号……");
    }

    /**
     * 异步统计挂号量
     */
    public void statisticAsync() {
        regExecutor.execute(() ->
        {
            try {
                TimeUnit.MICROSECONDS.sleep(200);

            } catch (InterruptedException e) {
                log.error(e.getMessage(), e);
            }
            log.debug(">>>>>>>>异步统计挂号量");
        });
    }

    /**
     * 回写操作
     */
    public void writeBack() {
        try {
            TimeUnit.MICROSECONDS.sleep(200);

        } catch (InterruptedException e) {
            log.error(e.getMessage(), e);
        }
        log.debug(">>>>>>>>>>回写操作");
    }

}
