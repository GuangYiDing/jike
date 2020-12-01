package me.cocode.jike.service.impl;

import me.cocode.jike.common.service.CommonMapper;
import me.cocode.jike.common.service.impl.CommonServiceImpl;
import me.cocode.jike.dao.CommentsMapper;
import me.cocode.jike.dto.CommentDto;
import me.cocode.jike.entity.Comments;
import me.cocode.jike.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 2020/11/28 14:06
 *
 * @author xiaodingsiren
 */
@Service
public class CommentServiceImpl  extends CommonServiceImpl<Comments> implements CommentService {

    @Autowired
    private CommentsMapper commentsMapper;

    @Override
    protected CommonMapper<Comments> getMapper() {
        return commentsMapper;
    }


    @Override
    public List<CommentDto> getCommByTrendId(Integer trendId) {
        return commentsMapper.getCommByTrendId(trendId);
    }
}
