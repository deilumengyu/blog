package com.example.black_myblog.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.black_myblog.entity.Page;
import com.example.black_myblog.mapper.PageMapper;
import com.example.black_myblog.service.PageService;
import com.example.black_myblog.service.RedisService;
import com.example.black_myblog.util.BeanCopyUtils;
import com.example.black_myblog.vo.PageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

import static com.example.black_myblog.constant.RedisPrefixConst.PAGE_COVER;

/**
 * 页面服务
 */
@Service
public class PageServiceImpl extends ServiceImpl<PageMapper, Page> implements PageService {
    @Autowired
    private PageMapper pageMapper;
    @Autowired
    private RedisService redisService;


        @Transactional(rollbackFor = Exception.class)
        @Override
        public void saveOrUpdatePage(PageVO pageVO) {
            Page page = BeanCopyUtils.copyObject(pageVO, Page.class);
            this.saveOrUpdate(page);
            // 删除缓存
            redisService.del(PAGE_COVER);
        }

        @Transactional(rollbackFor = Exception.class)
        @Override
        public void deletePage(Integer pageId) {
            pageMapper.deleteById(pageId);
            // 删除缓存
            redisService.del(PAGE_COVER);
        }

        @Transactional(rollbackFor = Exception.class)
        @Override
        public List<PageVO> listPages() {
            List<PageVO> pageVOList;
            // 查找缓存信息，不存在则从mysql读取，更新缓存
            Object pageList = redisService.get(PAGE_COVER);
            if (Objects.nonNull(pageList)) {
                pageVOList = JSON.parseObject(pageList.toString(), List.class);
            } else {
                pageVOList = BeanCopyUtils.copyList(pageMapper.selectList(null), PageVO.class);
                redisService.set(PAGE_COVER, JSON.toJSONString(pageVOList));
            }
            return pageVOList;
        }


    }




