package com.freightfox.pdfgenerator.configuration;

import com.freightfox.pdfgenerator.service.PdfManagerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync
public class AsyncThreadPoolConfig {

    Logger logger = LoggerFactory.getLogger(AsyncThreadPoolConfig.class);

    @Value("${com.cod.async.microservice.corepoolsize:1000}")
    private int corePoolSize;

    @Value("${com.cod.async.microservice.maxpoolsize:1000}")
    private int maxPoolSize;

    @Bean(name = "otcServiceAsyncTaskExecutor")
    public Executor asyncTaskExecutor(){
        logger.info("Creating Async Task Executor for OTCServiceApi to serve request in parallel threads");
        final ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(corePoolSize);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setThreadNamePrefix("asyncexe-");
        executor.initialize();
        return executor;
    }
}
