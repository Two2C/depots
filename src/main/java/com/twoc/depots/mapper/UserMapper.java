package com.twoc.depots.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.twoc.depots.bean.dto.UserDTO;
import com.twoc.depots.common.ResultDto;
import com.twoc.depots.entity.Module;
import com.twoc.depots.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {
    /**
     * 查询用户权限
     * @return
     */
    List<Module> getModulesOfUser(Integer userId);

    /**
     * 修改用户信息
     * @param userDTO
     * @return
     */
    int updateUser(UserDTO userDTO);
}
