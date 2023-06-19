package com.example.black_myblog.strategy;

import com.example.black_myblog.dto.ArticleSearchDTO;

import java.util.List;

/**
 * 搜索策略
 */
public interface SearchStrategy {

    /**
     * 搜索文章
     *
     * @param keywords 关键字
     * @return {@link List<ArticleSearchDTO>} 文章列表
     */
    List<ArticleSearchDTO> searchArticle(String keywords);

}
