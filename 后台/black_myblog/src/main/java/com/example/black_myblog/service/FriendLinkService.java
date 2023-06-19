package com.example.black_myblog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.black_myblog.dto.FriendLinkBackDTO;
import com.example.black_myblog.dto.FriendLinkDTO;
import com.example.black_myblog.entity.FriendLink;
import com.example.black_myblog.vo.ConditionVO;
import com.example.black_myblog.vo.FriendLinkVO;
import com.example.black_myblog.vo.PageResult;

import java.util.List;

public interface FriendLinkService extends IService<FriendLink> {
    /**
     * 查看友链
     *
     *  @return 友情链接
     */
   List<FriendLinkDTO> listFriendLink();

    /**
     * 查看后台友链信息
     *
     * @return 友情链接信息
     */
    PageResult<FriendLinkBackDTO> blackFriendLink(ConditionVO condition);

    /**
     * 保存或更新友链信息
     *
     * @return 返回状态
     */
    void updateFriendLink(FriendLinkVO friendLinkVO);
}
