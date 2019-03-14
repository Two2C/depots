package com.twoc.depots.bean.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class TradeDTO {
    /**
     * 交易单号
     */
    @NotNull(message = "id不能为空",groups = TradeDTO.UpdateTrade.class)
    private Integer tradeId;
    private Integer goodsId;
    private Integer number;
    private Integer tradeStatus;
    private Integer tradeType;
    private String goodsName;
    private String goodsPname;
    private String applyPerson;
    private String applyTime;
    private int page;
    private int limit;

    public interface UpdateTrade{

    }
}
