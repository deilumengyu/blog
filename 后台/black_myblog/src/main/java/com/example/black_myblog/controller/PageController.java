package com.example.black_myblog.controller;

import com.example.black_myblog.annotation.OptLog;
import com.example.black_myblog.service.PageService;
import com.example.black_myblog.vo.PageVO;
import com.example.black_myblog.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.example.black_myblog.constant.OptTypeConst.REMOVE;
import static com.example.black_myblog.constant.OptTypeConst.SAVE_OR_UPDATE;

/**
 * @author CH
 * @description: 页面控制
 */
@Api(tags = "页面模块")
@RestController
public class PageController {
    @Autowired
    private PageService pageService;
    /**
     * 删除页面
     *
     * @param pageId 页面id
     * @return {@link Result <>}
     */
    @OptLog(optType = REMOVE)
    @ApiOperation(value = "删除页面")
    @ApiImplicitParam(name = "pageId", value = "页面id", required = true, dataType = "Integer")
    @DeleteMapping("/admin/pages/{pageId}")
    public Result<?> deletePage(@PathVariable("pageId") Integer pageId) {
        pageService.deletePage(pageId);
        return Result.ok();
    }
    /**
     * 保存或更新页面
     *
     * @param pageVO 页面信息
     * @return {@link Result<>}
     */
    @OptLog(optType = SAVE_OR_UPDATE)
    @ApiOperation(value = "保存或更新页面")
    @PostMapping("/admin/pages")
    public Result<?> saveOrUpdatePage(@Valid @RequestBody PageVO pageVO) {
        pageService.saveOrUpdatePage(pageVO);
        return Result.ok();
    }

    /**
     * 获取页面列表
     *
     * @return {@link Result<PageVO>}
     */
    @ApiOperation(value = "获取页面列表")
    @GetMapping("/admin/pages")
    public Result<List<PageVO>> listPages() {
        return Result.ok(pageService.listPages());
    }
}
