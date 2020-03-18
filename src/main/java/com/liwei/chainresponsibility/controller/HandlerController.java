package com.liwei.chainresponsibility.controller;

import com.liwei.chainresponsibility.handler.GatewayHandler;
import com.liwei.chainresponsibility.service.GatewayHandlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liwei
 * @create: 2020/3/18 2:46 下午
 */
@RestController
public class HandlerController {
    @Autowired
    private GatewayHandlerService gatewayHandlerService;

    @GetMapping("/client")
    public String client() {
        GatewayHandler firstGatewayHandler = gatewayHandlerService.getFirstGatewayHandler();
        firstGatewayHandler.service();
        return "success";
    }
}
