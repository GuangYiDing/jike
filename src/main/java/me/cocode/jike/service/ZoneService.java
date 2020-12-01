package me.cocode.jike.service;

import me.cocode.jike.common.service.CommonService;
import me.cocode.jike.entity.Zones;

import java.util.List;

/**
 * 2020/11/27 16:12
 *
 * @author xiaodingsiren
 */
public interface ZoneService extends CommonService<Zones> {

    List<String> getZonesName();
}
