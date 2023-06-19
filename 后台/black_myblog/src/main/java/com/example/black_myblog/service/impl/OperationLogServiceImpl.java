package com.example.black_myblog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.black_myblog.dto.OperationLogDTO;
import com.example.black_myblog.entity.OperationLog;
import com.example.black_myblog.mapper.OperationLogMapper;
import com.example.black_myblog.service.OperationLogService;
import com.example.black_myblog.util.BeanCopyUtils;
import com.example.black_myblog.util.PageUtils;
import com.example.black_myblog.vo.ConditionVO;
import com.example.black_myblog.vo.PageResult;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 日志服务
 */
@Service
public class OperationLogServiceImpl extends ServiceImpl<OperationLogMapper, OperationLog> implements OperationLogService {

    @Override
    public PageResult<OperationLogDTO> listOperationLogs(ConditionVO conditionVO) {
        Page<OperationLog> page = new Page<>(PageUtils.getCurrent(),PageUtils.getSize());
        Page<OperationLog> operationLogPage=this.page(page,new LambdaQueryWrapper<OperationLog>()
                .like(StringUtils.isNotBlank(conditionVO.getKeywords()),OperationLog::getOptModule, conditionVO.getKeywords())
                .or()
                .like(StringUtils.isNotBlank(conditionVO.getKeywords()), OperationLog::getOptDesc, conditionVO.getKeywords())
                .orderByDesc(OperationLog::getId));
        List<OperationLogDTO> operationLogDTOList = BeanCopyUtils.copyList(operationLogPage.getRecords(), OperationLogDTO.class);
        return new PageResult<>(operationLogDTOList, (int) operationLogPage.getTotal());

    }
}
