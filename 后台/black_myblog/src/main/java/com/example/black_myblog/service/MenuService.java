package com.example.black_myblog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.black_myblog.dto.LabelOptionDTO;
import com.example.black_myblog.dto.MenuDTO;
import com.example.black_myblog.dto.UserMenuDTO;
import com.example.black_myblog.entity.Menu;
import com.example.black_myblog.vo.ConditionVO;
import com.example.black_myblog.vo.MenuVO;

import java.util.List;

public interface MenuService extends IService<Menu> {
   /**
    * 查看菜单列表
    *
    * @param conditionVO 条件
    * @return 菜单列表
    */
   List<MenuDTO> listMenus(ConditionVO conditionVO);

   /**
    * 新增或修改菜单
    *
    * @param menuVO 菜单信息
    */
   void saveOrUpdateMenu(MenuVO menuVO);

   /**
    * 删除菜单
    *
    * @param menuId 菜单id
    */
   void deleteMenu(Integer menuId);

   /**
    * 查看角色菜单选项
    *
    * @return 角色菜单选项
    */
   List<LabelOptionDTO> listMenuOptions();

   /**
    * 查看用户菜单
    *
    * @return 菜单列表
    */
   List<UserMenuDTO> listUserMenus();
}
