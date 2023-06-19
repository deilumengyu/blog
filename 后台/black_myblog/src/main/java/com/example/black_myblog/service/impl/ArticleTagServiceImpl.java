package com.example.black_myblog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.black_myblog.entity.ArticleTag;
import com.example.black_myblog.mapper.ArticleTagMapper;
import com.example.black_myblog.service.ArticleTagService;
import org.springframework.stereotype.Service;

/**
 * 文章标签服务
 */
@Service
public class ArticleTagServiceImpl extends ServiceImpl<ArticleTagMapper, ArticleTag> implements ArticleTagService {

}
