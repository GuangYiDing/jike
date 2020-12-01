package me.cocode.jike.common.service;

import tk.mybatis.mapper.common.*;

/**
 * 2020/11/25 10:29
 * 通用Mapper接口
 * @author xiaodingsiren
 */
public interface CommonMapper<T> extends Mapper<T>, MySqlMapper<T> ,IdsMapper<T>, ExampleMapper<T> {
}
