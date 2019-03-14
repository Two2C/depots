package com.twoc.depots.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.twoc.depots.bean.dto.TradeDTO;
import com.twoc.depots.bean.vo.TradeVO;
import com.twoc.depots.common.ResultDto;
import com.twoc.depots.entity.Trade;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TradeMapper extends BaseMapper<Trade> {
    /**
     * 查询申请列表
     * @param tradeDTO
     * @return
     */
    List<TradeVO> selectTrades(TradeDTO tradeDTO);

    /**
     * 更新
     * @param tradeDTO
     * @return
     */
    int updates(TradeDTO tradeDTO);
}
