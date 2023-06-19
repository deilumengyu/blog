package com.example.black_myblog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.black_myblog.entity.Menu;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuMapper extends BaseMapper<Menu> {
    List<Menu> listMenusByUserInfoId(Integer userInfoId);
}
