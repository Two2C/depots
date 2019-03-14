package com.twoc.depots.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
@TableName("depot_trade")
public class Trade {
    /**
     * 交易单号
     */
    @TableField("trade_id")
    private Integer tradeId;
    /**
     * 商品id
     */
    @TableField("goods_id")
    private Integer goodsId;

    /**
     * 数量
     */
    @TableField("number")
    private Integer number;
    /**
     * 状态
     */
    @TableField("trade_status")
    private Integer tradeStatus;

    /**
     * 类型 0：入库 1：出库
     */
    @TableField("trade_type")
    private Integer tradeType;
    /**
     * 申请人
     */
    @TableField("apply_person")
    private String applyPerson;
    /**
     * 申请时间
     */
    @TableField("apply_time")
    private String applyTime;
    /**
     * 审核人
     */
    @TableField("approval_person")
    private String approvalPerson;
    /**
     * 审核时间
     */
    @TableField("approval_time")
    private String approvalTime;
    /**
     * 检验人
     */
    @TableField("checkout_person")
    private String checkoutPerson;
    /**
     * 检验时间
     */
    @TableField("checkout_time")
    private String checkoutTime;
    /**
     * 确认人
     */
    @TableField("enter_person")
    private String enterPerson;
    /**
     * 确认时间
     */
    @TableField("enter_time")
    private String enterTime;
    /**
     * 出入库确认人
     */
    @TableField("come_out_person")
    private String comeOutPerson;
    /**
     * 出入库时间
     */
    @TableField("come_out_time")
    private String comeOutTime;


}
