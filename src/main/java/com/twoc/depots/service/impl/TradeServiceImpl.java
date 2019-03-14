package com.twoc.depots.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.twoc.depots.bean.dto.TradeDTO;
import com.twoc.depots.bean.vo.TradeVO;
import com.twoc.depots.common.LayuiData;
import com.twoc.depots.common.ResultDto;
import com.twoc.depots.entity.Role;
import com.twoc.depots.entity.Trade;
import com.twoc.depots.entity.User;
import com.twoc.depots.mapper.TradeMapper;
import com.twoc.depots.service.TradeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TradeServiceImpl implements TradeService {
    @Autowired
    private TradeMapper tradeMapper;
    @Override
    public LayuiData selectTrades(TradeDTO tradeDTO) {
        Page tradePage = new Page(tradeDTO.getPage(), tradeDTO.getLimit());
        List<TradeVO> tradeVOS =tradeMapper.selectTrades(tradeDTO);
        tradePage.setRecords(tradeVOS);
        return LayuiData.SETDATA(0, "成功", new Long(tradeVOS.size()).intValue(), tradeVOS, tradePage);
    }

    @Override
    public ResultDto updateStaus(TradeDTO tradeDTO) {
        int result = tradeMapper.update(new Trade().setTradeStatus(tradeDTO.getTradeStatus()), new UpdateWrapper<Trade>().eq("trade_id", tradeDTO.getTradeId()));
        if(result>0){
            return ResultDto.succeedResult("审核成功");
        }
        return ResultDto.failResult("审核失败");
    }

    @Override
    public ResultDto addPlan(TradeDTO tradeDTO) {
        Trade trade=new Trade();
        BeanUtils.copyProperties(tradeDTO,trade);
        int result=tradeMapper.insert(trade);
        if(result>0){
            return ResultDto.succeedResult("添加成功");
        }
        return ResultDto.failResult("添加成功");
    }

    @Override
    public TradeVO selectById(Integer tradeId) {
        Trade trade = tradeMapper.selectOne(new QueryWrapper<Trade>().eq("trade_id", tradeId));
        TradeVO tradeVO=new TradeVO();
        BeanUtils.copyProperties(trade,tradeVO);
        return tradeVO;
    }

    @Override
    public ResultDto updates(TradeDTO tradeDTO) {
        int result= tradeMapper.updates(tradeDTO);
        if(result>0){
            return ResultDto.succeedResult("修改成功");
        }
        return ResultDto.failResult("修改失败");
    }
}