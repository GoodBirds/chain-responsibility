package com.liwei.chainresponsibility.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author liwei
 * @create: 2020/3/18 2:44 下午
 */
@Component
@Slf4j
public class ConversationHandler extends GatewayHandler {

    @Override
    public void service() {
        log.info("第三关 用户的会话信息拦截.......");
    }
}
