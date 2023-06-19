package com.example.black_myblog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.black_myblog.dto.UniqueViewDTO;
import com.example.black_myblog.entity.UniqueView;

import java.util.List;

public interface UniqueViewService  extends IService<UniqueView> {
    /**
     * 获取7天用户量统计
     *
     * @return 用户量
     */
    List<UniqueViewDTO> listUniqueViews();
}
