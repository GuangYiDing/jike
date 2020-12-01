package me.cocode.jike.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


/**
 * 2020/11/27 08:16
 * 发布动态dto
 *
 * @author xiaodingsiren
 */
@Data
public class PostTrendDto {
    /**
     * 动态图片列表
     */
    private String[] images;
    /**
     * 动态内容
     */
    private String content;
    /**
     * 发布的圈子
     */
    private String zone;
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

}
