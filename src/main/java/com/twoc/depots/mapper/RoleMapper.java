package com.twoc.depots.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.twoc.depots.bean.dto.RoleDTO;
import com.twoc.depots.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 角色mapper
 */
@Mapper
@Repository
public interface RoleMapper extends BaseMapper<Role> {
    /**
     * 查询列表
     * @param page
     * @return
     */
    IPage<Role> selectPageVo(Page page);

    /**
     * 查询用户角色信息
     * @param userId
     * @return
     */
    List<Role> selectByUser(Integer userId);

    List<RoleDTO> selectAllByUser(Integer userId);
}
