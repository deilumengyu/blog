package com.example.black_myblog.util;

import com.example.black_myblog.dto.UserDetailDTO;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * 登入信息工具类
 */
public class UserUtils {
    /**
     * 获取当前登录用户
     * @return 用户登录信息
     */
    public static UserDetailDTO getLoginUser() {
        return (UserDetailDTO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
