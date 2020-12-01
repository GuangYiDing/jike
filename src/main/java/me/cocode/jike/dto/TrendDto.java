package me.cocode.jike.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import me.cocode.jike.entity.Trend;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 2020/11/27 20:22
 *
 * @author xiaodingsiren
 */
@Data
public class TrendDto  {

    /**
     * 动态id
     */
    private Integer trendId;
    /**
     * 圈子名称
     */
    private String zoneName;
    /**
     * 圈子头像路径
     */
    private String zoneAvatar;
    /**
     * 发布者昵称
     */
    private String userName;
    /**
     * 发布者头像路径
     */
    private String userAvatar;
    /**
     * 发布者id
     */
    private Integer userId;
    /**
     * 点赞数
     */
    private Integer likesCount;
    /**
     * 评论数
     */
    private Integer commentsCount;
    /**
     * 动态图片列表
     */
    private String images;
    /**
     * 圈子简介
     */
    private String description;
    /**
     * 用户签名
     */
    private String signature;
    /**
     * 动态内容
     */
    private String content;
    /**
     * 发布时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private Date createTime;

}
