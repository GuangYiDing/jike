package me.cocode.jike.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import me.cocode.jike.common.cro.R;
import me.cocode.jike.entity.Zones;
import me.cocode.jike.service.ZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 2020/11/27 16:08
 *
 * @author xiaodingsiren
 */
@RestController
@RequestMapping("/zones")
@Api(tags = "圈子管理")
public class ZoneController {

    @Autowired
    private ZoneService zoneService;

    @GetMapping("/names")
    @ApiOperation("获取圈子名称")
    public R<List<String>> getZonesName() {
        return R.success(zoneService.getZonesName());
    }

    @GetMapping
    @ApiOperation("获取圈子信息")
    public R<List<Zones>> getZones(){
        return R.success(zoneService.selectAll());
    }
}
