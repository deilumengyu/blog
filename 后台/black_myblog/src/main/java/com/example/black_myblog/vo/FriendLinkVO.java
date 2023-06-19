package com.example.black_myblog.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * 友链
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(description = "友链")
public class FriendLinkVO {

    /**
     * 链接名
     */
    @NotBlank(message = "链接名不为空")
    @ApiModelProperty(name = "linkName", value = "链接名", required = true, dataType = "String")
    private String linkName;

    /**
     * 链接头像
     */
    @NotBlank
    @ApiModelProperty(name = "linkAvatar", value = "链接头像", required = true, dataType = "String")
    private String linkAvatar;

    /**
     * 链接地址
     */
    @NotBlank
    @ApiModelProperty(name = "linkAddress",value = "链接地址",required = true,dataType = "String")
    private String linkAddress;

    /**
     * 链接介绍
     */
    private String linkIntro;
}
