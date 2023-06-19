package com.example.black_myblog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.black_myblog.dto.FriendLinkBackDTO;
import com.example.black_myblog.dto.FriendLinkDTO;
import com.example.black_myblog.entity.FriendLink;
import com.example.black_myblog.mapper.FriendLinkMapper;
import com.example.black_myblog.service.FriendLinkService;
import com.example.black_myblog.util.BeanCopyUtils;
import com.example.black_myblog.util.PageUtils;
import com.example.black_myblog.vo.ConditionVO;
import com.example.black_myblog.vo.FriendLinkVO;
import com.example.black_myblog.vo.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author CH
 * @description: 友链服务
 */
@Service
public class FriendLinkServiceImpl extends ServiceImpl<FriendLinkMapper,FriendLink> implements FriendLinkService {
    @Autowired
    private FriendLinkMapper friendLinkMapper;

    /**
     * 查看友链
     */
    @Override
    public List<FriendLinkDTO> listFriendLink() {
        List<FriendLink> friendLink=friendLinkMapper.selectList(null);
        return  BeanCopyUtils.copyList(friendLink,FriendLinkDTO.class);
    }

    /**
     * 查看后台友链
     */
    @Override
    public PageResult<FriendLinkBackDTO> blackFriendLink(ConditionVO condition) {
        // 分页查询友链列表
        Page<FriendLink> page = new Page<>(PageUtils.getCurrent(), PageUtils.getSize());
        Page<FriendLink> friendLinkPage = friendLinkMapper.selectPage(page, new LambdaQueryWrapper<FriendLink>()
                .like(StringUtils.isNotBlank(condition.getKeywords()), FriendLink::getLinkName, condition.getKeywords()));
        // 转换DTO
        List<FriendLinkBackDTO> friendLinkBackDTOList = BeanCopyUtils.copyList(friendLinkPage.getRecords(), FriendLinkBackDTO.class);
        return new PageResult<>(friendLinkBackDTOList, (int) friendLinkPage.getTotal());
    }

    /**
     * 保存或修改友链
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateFriendLink(FriendLinkVO friendLinkVO){
        FriendLink friendLink=BeanCopyUtils.copyObject(friendLinkVO,FriendLink.class);
       this.saveOrUpdate(friendLink);
    }

}
