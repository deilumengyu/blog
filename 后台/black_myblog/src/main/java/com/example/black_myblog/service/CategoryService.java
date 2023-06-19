package com.example.black_myblog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.black_myblog.dto.CategoryBackDTO;
import com.example.black_myblog.dto.CategoryDTO;
import com.example.black_myblog.dto.CategoryOptionDTO;
import com.example.black_myblog.entity.Category;
import com.example.black_myblog.vo.CategoryVO;
import com.example.black_myblog.vo.ConditionVO;
import com.example.black_myblog.vo.PageResult;

import java.util.List;

/**
 * 文章分类服务
 **/
public interface CategoryService extends IService<Category> {
    /**
     * 查询分类列表
     *
     * @return 分类列表
     */
    PageResult<CategoryDTO> listCategories();

    /**
     * 查询后台分类
     *
     * @param conditionVO 条件
     * @return {@link PageResult<CategoryBackDTO>} 后台分类
     */
    PageResult<CategoryBackDTO> listBackCategories(ConditionVO conditionVO);

    /**
     * 搜索文章分类
     *
     * @param condition 条件
     * @return {@link List <CategoryOptionDTO>} 分类列表
     */
    List<CategoryOptionDTO> listCategoriesBySearch(ConditionVO condition);

    /**
     * 删除分类
     *
     * @param categoryIdList 分类id集合
     */
    void deleteCategory(List<Integer> categoryIdList);

    /**
     * 添加或修改分类
     *
     * @param categoryVO 分类
     */
    void saveOrUpdateCategory(CategoryVO categoryVO);
}
