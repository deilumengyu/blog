package com.example.black_myblog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.black_myblog.dto.RoleDTO;
import com.example.black_myblog.dto.UserRoleDTO;
import com.example.black_myblog.entity.Role;
import com.example.black_myblog.vo.ConditionVO;
import com.example.black_myblog.vo.PageResult;
import com.example.black_myblog.vo.RoleVO;

import java.util.List;

/**
 * 角色服务
 */
public interface RoleService extends IService<Role> {

    /**
     * 获取用户角色选项
     *
     * @return 角色
     */
    List<UserRoleDTO> listUserRoles();

    /**
     * 查询角色列表
     *
     * @param conditionVO 条件
     * @return 角色列表
     */
    PageResult<RoleDTO> listRoles(ConditionVO conditionVO);

    /**
     * 保存或更新角色
     *
     * @param roleVO 角色
     */
    void saveOrUpdateRole(RoleVO roleVO);

    /**
     * 删除角色
     * @param roleIdList 角色id列表
     */
    void deleteRoles(List<Integer> roleIdList);

}
