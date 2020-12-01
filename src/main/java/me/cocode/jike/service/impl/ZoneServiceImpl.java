package me.cocode.jike.service.impl;

import me.cocode.jike.common.service.CommonMapper;
import me.cocode.jike.common.service.impl.CommonServiceImpl;
import me.cocode.jike.dao.ZonesMapper;
import me.cocode.jike.entity.Zones;
import me.cocode.jike.service.ZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.LinkedList;
import java.util.List;

/**
 * 2020/11/27 16:14
 *
 * @author xiaodingsiren
 */
@Service
public class ZoneServiceImpl extends CommonServiceImpl<Zones> implements ZoneService {

   @Autowired
   private ZonesMapper zonesMapper;

    @Override
    protected CommonMapper<Zones> getMapper() {
        return zonesMapper;
    }

    @Override
    public List<String> getZonesName() {
        Example example = new Example(Zones.class);
        example.selectProperties("zoneName");
        List<Zones> zones = zonesMapper.selectByExample(example);
        List<String> result = new LinkedList<>();
        for (Zones zone : zones) {
            result.add(zone.getZoneName());
        }
        return result;
    }
}
