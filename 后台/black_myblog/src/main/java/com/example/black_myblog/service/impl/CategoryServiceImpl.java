package com.example.black_myblog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.black_myblog.dto.CategoryBackDTO;
import com.example.black_myblog.dto.CategoryDTO;
import com.example.black_myblog.dto.CategoryOptionDTO;
import com.example.black_myblog.entity.Article;
import com.example.black_myblog.entity.Category;
import com.example.black_myblog.exception.BizException;
import com.example.black_myblog.mapper.ArticleMapper;
import com.example.black_myblog.mapper.CategoryMapper;
import com.example.black_myblog.service.CategoryService;
import com.example.black_myblog.util.BeanCopyUtils;
import com.example.black_myblog.util.PageUtils;
import com.example.black_myblog.vo.CategoryVO;
import com.example.black_myblog.vo.ConditionVO;
import com.example.black_myblog.vo.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * 文章分类
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private ArticleMapper articleMapper;
    @Override
    public PageResult<CategoryDTO> listCategories() {
        return new PageResult<>(categoryMapper.listCategoryDTO(), categoryMapper.selectCount(null));
    }

    @Override
    public PageResult<CategoryBackDTO> listBackCategories(ConditionVO conditionVO) {
        // 查询分类数量
        Integer count = categoryMapper.selectCount(new LambdaQueryWrapper<Category>()
                .like(StringUtils.isNotBlank(conditionVO.getKeywords()), Category::getCategoryName, conditionVO.getKeywords()));
        if (count == 0) {
            return new PageResult<>();
        }
        // 分页查询分类列表
        List<CategoryBackDTO> categoryList = categoryMapper.listCategoryBackDTO(PageUtils.getLimitCurrent(), PageUtils.getSize(), conditionVO);
        return new PageResult<>(categoryList, count);
    }

    @Override
    public List<CategoryOptionDTO> listCategoriesBySearch(ConditionVO condition) {
        // 搜索分类
        List<Category> categoryList = categoryMapper.selectList(new LambdaQueryWrapper<Category>()
                .like(StringUtils.isNotBlank(condition.getKeywords()), Category::getCategoryName, condition.getKeywords())
                .orderByDesc(Category::getId));
        return BeanCopyUtils.copyList(categoryList, CategoryOptionDTO.class);

    }

    @Override
    public void deleteCategory(List<Integer> categoryIdList) {
// 查询分类id下是否有文章
        Integer count = articleMapper.selectCount(new LambdaQueryWrapper<Article>()
                .in(Article::getCategoryId, categoryIdList));
        if (count > 0) {
            throw new BizException("删除失败，该分类下存在文章");
        }
        categoryMapper.deleteBatchIds(categoryIdList);
    }

    @Override
    public void saveOrUpdateCategory(CategoryVO categoryVO) {
    Category category=categoryMapper.selectOne(new LambdaQueryWrapper<Category>()
            .select(Category::getId)
            .eq(Category::getCategoryName,categoryVO.getCategoryName()));
    if(Objects.nonNull(category) && !category.getId().equals(categoryVO.getId())){
        throw new BizException("分类名已存在");
    }
        Category newCategory = Category.builder()
                .id(categoryVO.getId())
                .categoryName(categoryVO.getCategoryName())
                .build();
        this.saveOrUpdate(newCategory);
    }
}
