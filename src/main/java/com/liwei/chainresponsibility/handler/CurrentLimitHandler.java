package com.liwei.chainresponsibility.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * api接口限流
 *
 * @author liwei
 * @create: 2020/3/18 2:42 下午
 */
@Component
@Slf4j
public class CurrentLimitHandler extends GatewayHandler {

    @Override
    public void service() {
        log.info("第一关 API接口限流操作.....");
        // 指向下一个handler
        nextService();
    }
}
