package com.example.black_myblog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.black_myblog.dto.UniqueViewDTO;
import com.example.black_myblog.entity.UniqueView;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


@Repository
public interface UniqueViewMapper extends BaseMapper<UniqueView> {

    /**
     * 获取7天用户量
     *
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @return 用户量
     */
    List<UniqueViewDTO> listUniqueViews(@Param("startTime") Date startTime, @Param("endTime") Date endTime);

}
