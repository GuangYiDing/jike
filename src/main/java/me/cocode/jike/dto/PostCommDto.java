package me.cocode.jike.dto;

import lombok.Data;
import me.cocode.jike.entity.Comments;

/**
 * 2020/12/1 14:49
 *
 * @author xiaodingsiren
 */
@Data
public class PostCommDto  {

    private Integer trendId;
    private String content;
    private String images;
}
