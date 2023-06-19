package com.example.black_myblog.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.example.black_myblog.dto.TagBackDTO;
import com.example.black_myblog.dto.TagDTO;
import com.example.black_myblog.entity.Tag;
import com.example.black_myblog.vo.ConditionVO;
import com.example.black_myblog.vo.PageResult;
import com.example.black_myblog.vo.TagVO;

import java.util.List;

/**
 * 标签服务
 */
public interface TagService extends IService<Tag> {

    /**
     * 查询标签列表
     *
     * @return 标签列表
     */
    PageResult<TagDTO> listTags();

    /**
     * 查询后台标签
     *
     * @param condition 条件
     * @return {@link PageResult<TagBackDTO>} 标签列表
     */
    PageResult<TagBackDTO> listTagBackDTO(ConditionVO condition);

    /**
     * 搜索文章标签
     *
     * @param condition 条件
     * @return {@link List<TagDTO>} 标签列表
     */
    List<TagDTO> listTagsBySearch(ConditionVO condition);

    /**
     * 删除标签
     *
     * @param tagIdList 标签id集合
     */
    void deleteTag(List<Integer> tagIdList);

    /**
     * 保存或更新标签
     *
     * @param tagVO 标签
     */
    void saveOrUpdateTag(TagVO tagVO);

}
