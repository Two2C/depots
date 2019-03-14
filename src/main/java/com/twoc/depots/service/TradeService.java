package com.twoc.depots.service;

import com.twoc.depots.bean.dto.TradeDTO;
import com.twoc.depots.bean.vo.TradeVO;
import com.twoc.depots.common.LayuiData;
import com.twoc.depots.common.ResultDto;

public interface TradeService {
    /**
     * 查询申请列表
     * @param tradeDTO
     * @return
     */
    LayuiData selectTrades(TradeDTO tradeDTO);

    /**
     * 审核出入库申请
     * @param tradeDTO
     * @return
     */
    ResultDto updateStaus(TradeDTO tradeDTO);

    /**
     * 添加计划
     * @param tradeDTO
     * @return
     */
    ResultDto addPlan(TradeDTO tradeDTO);

    /**
     * 根据id查询
     * @param tradeId
     * @return
     */
    TradeVO selectById(Integer tradeId);

    /**
     * 更新
     * @param tradeDTO
     * @return
     */
    ResultDto updates(TradeDTO tradeDTO);
}
