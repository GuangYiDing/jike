package me.cocode.jike.netty.Enum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author guangyi
 * @Description
 * @Date 2021/5/14 下午2:32
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum NotifyTypeEnum {
    /**
     * 评论通知
     */
    COMMENT(1,"评论通知"),
    LIKE(2,"点赞通知"),
    FOLLOW(3,"被关注通知"),
    SYSTEM(0,"系统通知")
    ;
    private Integer typeId;
    private String typeValue;
}
