package com.example.black_myblog.controller;

import com.example.black_myblog.annotation.OptLog;
import com.example.black_myblog.dto.FriendLinkBackDTO;
import com.example.black_myblog.dto.FriendLinkDTO;
import com.example.black_myblog.service.FriendLinkService;
import com.example.black_myblog.vo.ConditionVO;
import com.example.black_myblog.vo.FriendLinkVO;
import com.example.black_myblog.vo.PageResult;
import com.example.black_myblog.vo.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.example.black_myblog.constant.OptTypeConst.*;

/**
 * @author CH
 * @description: 友链控制器
 */
@RestController
public class FriendLinkController {
    @Autowired
    private FriendLinkService friendLinkService;
    /**
     * 查看友情链接
     *
     * @return  {@link Result<FriendLinkDTO>} 友链列表
     */
    @GetMapping("/links")
    public Result<List<FriendLinkDTO>> listFriendLink(){
        return Result.ok(friendLinkService.listFriendLink());
    }

    /**
     * 查看后台友情链接
     * @param conditionVO 查询条件
     * @return {@link Result<PageResult<FriendLinkBackDTO>>} 查询友链列表
     */
    @GetMapping("/admin/links")
    public Result<PageResult<FriendLinkBackDTO>> blackFriendLink(ConditionVO conditionVO){
        return Result.ok(friendLinkService.blackFriendLink(conditionVO));
    }

    /**
     * 保存或修改后台友链
     * @param friendLinkVO  友链
     * @return  {@link Result<>}
     */
    @OptLog(optType = SAVE_OR_UPDATE)
    @ApiOperation(value = "保存或修改友链")
    @PostMapping("/admin/links")
    public Result<?> updateFriendLink(@Valid @RequestBody FriendLinkVO friendLinkVO){
        friendLinkService.updateFriendLink(friendLinkVO);
        return Result.ok();
    }

    /**
     * 删除友链
     *
     * @param linkIdList 友链id列表
     * @return {@link Result<>}
     */
    @OptLog(optType = REMOVE)
    @ApiOperation(value = "删除友链")
    @DeleteMapping("/admin/links")
    public Result<?> deleteFriendLink(@RequestBody List<Integer> linkIdList) {
        friendLinkService.removeByIds(linkIdList);
        return Result.ok();
    }
}
