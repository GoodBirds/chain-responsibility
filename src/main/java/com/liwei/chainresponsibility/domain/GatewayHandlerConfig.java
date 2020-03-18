package com.liwei.chainresponsibility.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author liwei
 * @create: 2020/3/18 2:55 下午
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "gateway_handler_config")
public class GatewayHandlerConfig {
    /**
     * 主键ID
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    @ApiModelProperty(value = "主键ID")
    private Integer id;

    /**
     * handler名称
     */
    @Column(name = "handler_name")
    @ApiModelProperty(value = "handler名称")
    private String handlerName;

    /**
     * handler主键id
     */
    @Column(name = "handler_id")
    @ApiModelProperty(value = "handler主键id")
    private String handlerId;

    @Column(name = "prev_handler_id")
    @ApiModelProperty(value = "")
    private String prevHandlerId;

    /**
     * 下一个handler
     */
    @Column(name = "next_handler_id")
    @ApiModelProperty(value = "下一个handler")
    private String nextHandlerId;
}