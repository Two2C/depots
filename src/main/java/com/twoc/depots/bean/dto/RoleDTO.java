package com.twoc.depots.bean.dto;

import com.twoc.depots.entity.Module;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class RoleDTO {
    /**
     * id
     */
    @NotNull(message = "角色id不能为空",groups = {RoleDTO.UpdateRole.class,RoleDTO.AddRole.class})
    private Integer roleId;
    private boolean checked;
    /**
     * 名称
     */
    @NotNull(message = "角色名称不能为空",groups = {RoleDTO.AddRole.class})
    private String roleName;
    /**
     * 备注
     */
    private String roleRemark;
    /**
     * 状态
     */
    @NotNull(message = "状态不能为空")
    private Integer roleStatus;

    private List<Module> modules;
    private int page;
    private int limit;
    private Integer userId;
    /**
     * 更新角色状态
     */
    public interface UpdateRole{

    }

    /**
     * 添加角色
     */
    public interface  AddRole{

    }
}
