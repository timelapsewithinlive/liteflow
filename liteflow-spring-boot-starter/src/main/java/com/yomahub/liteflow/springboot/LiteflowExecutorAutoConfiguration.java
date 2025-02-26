package com.yomahub.liteflow.springboot;

import com.yomahub.liteflow.property.LiteflowConfig;
import com.yomahub.liteflow.util.ExecutorHelper;
import com.yomahub.liteflow.util.LiteFlowExecutorPoolShutdown;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ExecutorService;

/**
 * 线程池装配类
 * 这个装配前置条件是需要LiteflowConfig，LiteflowPropertyAutoConfiguration以及SpringAware
 * @author justin.xu
 */
@Configuration
@AutoConfigureAfter({LiteflowPropertyAutoConfiguration.class})
@ConditionalOnProperty(prefix = "liteflow", name = "enable", havingValue = "true")
@ConditionalOnBean(LiteflowConfig.class)
public class LiteflowExecutorAutoConfiguration {

    @Bean("whenExecutors")
    public ExecutorService executorService(LiteflowConfig liteflowConfig) {
        Integer useWorker = liteflowConfig.getWhenMaxWorkers();
        Integer useQueue = liteflowConfig.getWhenQueueLimit();
        return ExecutorHelper.buildExecutor(useWorker, useQueue, "liteflow-when-thead", false);
    }

    @Bean
    public LiteFlowExecutorPoolShutdown liteFlowExecutorPoolShutdown() {
        return new LiteFlowExecutorPoolShutdown();
    }
}
