package me.cocode.jike.service.impl;

import me.cocode.jike.common.service.CommonMapper;
import me.cocode.jike.common.service.impl.CommonServiceImpl;
import me.cocode.jike.dao.TrendMapper;
import me.cocode.jike.dao.UsersMapper;
import me.cocode.jike.dao.ZonesMapper;
import me.cocode.jike.dto.PostTrendDto;
import me.cocode.jike.dto.TrendDto;
import me.cocode.jike.entity.Trend;
import me.cocode.jike.entity.Zones;
import me.cocode.jike.service.TrendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * 2020/11/27 08:10
 *
 * @author xiaodingsiren
 */
@Service
public class TrendServiceImpl extends CommonServiceImpl<Trend> implements TrendService {

    @Autowired
    private TrendMapper trendMapper;

    @Autowired
    private ZonesMapper zonesMapper;

    @Autowired
    private UsersMapper usersMapper;

    @Override
    protected CommonMapper<Trend> getMapper() {
        return trendMapper;
    }


    @Override
    public Trend postTrend(PostTrendDto dto) {
        String zoneName = dto.getZone();
        Example example  = new Example(Zones.class);
        example.selectProperties("id");
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("zoneName",zoneName);
        Zones zone = zonesMapper.selectOneByExample(example);
        Trend result = new Trend();
        result.setContent(dto.getContent());
        result.setImages(Arrays.toString(dto.getImages()));
        result.setCreateTime(new Date(System.currentTimeMillis()));
        result.setZoneId(zone.getId());
        return result;
    }

    @Override
    public List<TrendDto> getRecommendTrends() {
        return trendMapper.getRecommendTrends();
    }

    @Override
    public int increaseCommentCount(Integer trendId) {
        return trendMapper.increaseCommentCount(trendId);
    }

    @Override
    public TrendDto getTrendById(Integer trendId) {
        return  trendMapper.getTrendById(trendId);
    }
}
