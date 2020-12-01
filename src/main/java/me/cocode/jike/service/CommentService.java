package me.cocode.jike.service;

import me.cocode.jike.common.service.CommonService;
import me.cocode.jike.dto.CommentDto;
import me.cocode.jike.entity.Comments;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 2020/11/28 14:06
 *
 * @author xiaodingsiren
 */
public interface CommentService extends CommonService<Comments> {

        List<CommentDto> getCommByTrendId(Integer trendId);
}
