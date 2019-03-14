package com.twoc.depots.web.controller;

import com.twoc.depots.bean.dto.RoleDTO;
import com.twoc.depots.bean.dto.TradeDTO;
import com.twoc.depots.bean.vo.TradeVO;
import com.twoc.depots.common.LayuiData;
import com.twoc.depots.common.ResultDto;
import com.twoc.depots.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/plan")
public class PlanController {
    @Autowired
    private TradeService tradeService;

    /**
     * 查询出入库申请列表
     * @param tradeDTO
     * @return
     */
    @GetMapping("/list")
    public LayuiData selectList(TradeDTO tradeDTO){
        System.out.println(tradeDTO);
        return tradeService.selectTrades(tradeDTO);
    }

    /**
     * 审核申请
     * @return
     */
    @PostMapping("/update/{tradeId}/{tradeStatus}")
    public ResultDto updateStaus(@PathVariable Integer tradeId,@PathVariable Integer tradeStatus){
        TradeDTO tradeDto=new TradeDTO();
        tradeDto.setTradeId(tradeId);
        tradeDto.setTradeStatus(tradeStatus);
        return tradeService.updateStaus(tradeDto);
    }


    /**
     * 添加计划
     * @return
     */
    @PostMapping("/add")
    public ResultDto addRole(@Validated @RequestBody TradeDTO tradeDTO){
        //添加当前用户
        return tradeService.addPlan(tradeDTO);
    }

    /**
     * 查询计划信息
     * @return
     */
    @PostMapping("/selectById/{tradeId}")
    public TradeVO selectById(@PathVariable Integer tradeId){
        return tradeService.selectById(tradeId);
    }
    @PostMapping("/updates")
    public ResultDto updates(@Validated(value =TradeDTO.UpdateTrade.class ) @RequestBody TradeDTO tradeDTO){
        return tradeService.updates(tradeDTO);
    }
}
