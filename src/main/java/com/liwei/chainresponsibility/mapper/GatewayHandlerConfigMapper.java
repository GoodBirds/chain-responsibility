package com.liwei.chainresponsibility.mapper;

import com.liwei.chainresponsibility.domain.GatewayHandlerConfig;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author liwei
 * @create: 2020/3/18 2:55 下午
 */
public interface GatewayHandlerConfigMapper extends Mapper<GatewayHandlerConfig> {


    /**
     * 获取第一个处理handler config
     *
     * @return
     */
    @Select("SELECT id, handler_name AS handlerName,handler_id AS handlerid ,prev_handler_id AS prevhandlerid ,next_handler_id AS nexthandlerid from gateway_handler_config where prev_handler_id is null limit 1")
    GatewayHandlerConfig queryFirstGatewayHandlerConfig();

    /**
     * 根据handler查询
     * @param handlerId
     * @return
     */
    @Select("SELECT id, handler_name AS handlerName,handler_id AS handlerid ,prev_handler_id AS prevhandlerid ,next_handler_id AS nexthandlerid from gateway_handler_config where handler_id=#{handlerId}")
    GatewayHandlerConfig queryByHandlerId(String handlerId);
}