package com.liwei.chainresponsibility.service;

import com.liwei.chainresponsibility.domain.GatewayHandlerConfig;
import com.liwei.chainresponsibility.handler.GatewayHandler;
import com.liwei.chainresponsibility.mapper.GatewayHandlerConfigMapper;
import com.liwei.chainresponsibility.utils.SpringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @author liwei
 * @create: 2020/3/18 2:37 下午
 */
@Service
@Slf4j
public class GatewayHandlerService {

    @Autowired
    private GatewayHandlerConfigMapper handlerConfigMapper;

    private GatewayHandler firstGatewayHandler;

    /**
     * 获取数据第一个handler
     *
     * @return
     */
    public GatewayHandler getFirstGatewayHandler() {
        if (firstGatewayHandler != null) {
            return firstGatewayHandler;
        }
        GatewayHandlerConfig firstGatewayHandlerConfig = handlerConfigMapper.queryFirstGatewayHandlerConfig();
        if (firstGatewayHandlerConfig == null) {
            return null;
        }
        String firstHandlerId = firstGatewayHandlerConfig.getHandlerId();
        String nextHandlerId = firstGatewayHandlerConfig.getNextHandlerId();
        firstGatewayHandler = SpringUtils.getBean(firstHandlerId, GatewayHandler.class);
        GatewayHandler secondGatewayHandler = null;
        GatewayHandler threeGatewayHandler = null;
        while (!StringUtils.isEmpty(nextHandlerId)) {
            secondGatewayHandler = SpringUtils.getBean(nextHandlerId, GatewayHandler.class);
            if (secondGatewayHandler == null) {
                break;
            }
            firstGatewayHandler.setNextGatewayHandler(secondGatewayHandler);
            GatewayHandlerConfig nextGatewayHandlerConfig = handlerConfigMapper.queryByHandlerId(nextHandlerId);
            if (nextGatewayHandlerConfig == null) {
                break;
            }
            nextHandlerId = nextGatewayHandlerConfig.getNextHandlerId();
            threeGatewayHandler = SpringUtils.getBean(nextHandlerId, GatewayHandler.class);
            secondGatewayHandler.setNextGatewayHandler(threeGatewayHandler);
            break;
        }
        return firstGatewayHandler;
    }
}

