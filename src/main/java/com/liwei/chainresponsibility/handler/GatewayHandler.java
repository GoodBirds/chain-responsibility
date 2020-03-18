package com.liwei.chainresponsibility.handler;

/**
 * @author liwei
 * @create: 2020/3/18 2:39 下午
 */
public abstract class GatewayHandler {

    /**
     * 执行下一个handler
     */
    protected GatewayHandler nextGatewayHandler;

    public void setNextGatewayHandler(GatewayHandler nextGatewayHandler) {
        this.nextGatewayHandler = nextGatewayHandler;
    }

    /**
     * 实现的handler处理方案，必须实现
     */
    public abstract void service();

    protected void nextService() {
        if (nextGatewayHandler != null) {
            // 指向下一个handler
            nextGatewayHandler.service();
        }
    }
}
