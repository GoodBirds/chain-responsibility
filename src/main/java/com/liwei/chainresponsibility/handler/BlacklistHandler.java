package com.liwei.chainresponsibility.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 黑名单拦截
 * @author liwei
 * @create: 2020/3/18 2:43 下午
 */
@Component
@Slf4j
public class BlacklistHandler extends GatewayHandler {
    @Override
    public void service() {
        log.info("第二关 黑名单拦截.......");
        // 指向下一个handler
        nextService();
    }
}
