package com.twoc.depots.bean.dto;

import com.twoc.depots.entity.Module;
import com.twoc.depots.entity.Role;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Data
public class UserDTO {
    /**
     * 用户id
     */
    @NotNull(message = "用户id不能为空",groups = {UserDTO.Updates.class})
    private Integer userId;
    /**
     * 用户姓名
     */
    @NotNull(message = "用户姓名不能为空",groups = {UserDTO.Add.class})
    private String userName;
    /**
     * 用户密码
     */
    @NotNull(message = "用户密码不能为空",groups = {UserDTO.Add.class})
    private String userPwd;
    /**
     * 用户状态
     */
    @NotNull(message = "用户状态不能为空")
    private Integer userStatus;
    /**
     * 姓名
     */
    @NotNull(message = "姓名不能为空",groups = {UserDTO.Add.class})
    private String employeeName;
    /**
     * 联系电话
     */
    @NotNull(message = "联系电话不能为空",groups = {UserDTO.Add.class})
    private String phone;
    /**
     * 联系地址
     */
    @NotNull(message = "联系地址不能为空",groups = {UserDTO.Add.class})
    private String employeeAddress;
    /**
     * 出生日期
     */
    @NotNull(message = "出生日期不能为空",groups = {UserDTO.Add.class})
    private String birthday;
    /**
     * 性别
     */
    @NotNull(message = "性别不能为空",groups = {UserDTO.Add.class})
    private Integer sex;
    /**
     * 身份证号码
     */
    @NotNull(message = "身份证号码不能为空",groups = {UserDTO.Add.class})
    private String idCard;
    private List<RoleDTO> roles;
    private int page;
    private int limit;
    public interface Add{

    }
    public interface Updates{

    }
}
