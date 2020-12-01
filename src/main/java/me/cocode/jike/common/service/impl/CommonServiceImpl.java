package me.cocode.jike.common.service.impl;

import me.cocode.jike.common.service.CommonMapper;
import me.cocode.jike.entity.Users;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * 2020/11/26 14:31
 * 通用接口实现 getMapper需自己实现
 * @author xiaodingsiren
 */
public abstract class CommonServiceImpl<T> implements CommonMapper<T> {


    protected abstract CommonMapper<T> getMapper();


    @Override
    public int deleteByPrimaryKey(Object key) {
        return getMapper().deleteByExample(key);
    }

    @Override
    public int delete(T record) {
        return getMapper().delete(record);
    }

    @Override
    public int insert(T record) {
        return getMapper().insert(record);
    }

    @Override
    public int insertSelective(T record) {
        return getMapper().insertSelective(record);
    }

    @Override
    public boolean existsWithPrimaryKey(Object key) {
        return getMapper().existsWithPrimaryKey(key);
    }

    @Override
    public List<T> selectAll() {
        return getMapper().selectAll();
    }

    @Override
    public T selectByPrimaryKey(Object key) {
        return getMapper().selectByPrimaryKey(key);
    }

    @Override
    public int selectCount(T record) {
        return getMapper().selectCount(record);
    }

    @Override
    public List<T> select(T record) {
        return getMapper().select(record);
    }

    @Override
    public T selectOne(T record) {
        return getMapper().selectOne(record);
    }

    @Override
    public int updateByPrimaryKey(T record) {
        return getMapper().updateByPrimaryKey(record);
    }

    @Override
    public int updateByPrimaryKeySelective(T record) {
        return getMapper().updateByPrimaryKeySelective(record);
    }

    @Override
    public int deleteByExample(Object example) {
        return getMapper().deleteByExample(example);
    }

    @Override
    public List<T> selectByExample(Object example) {
        return getMapper().selectByExample(example);
    }

    @Override
    public int selectCountByExample(Object example) {
        return getMapper().selectCountByExample(example);
    }

    @Override
    public T selectOneByExample(Object example) {
        return getMapper().selectOneByExample(example);
    }

    @Override
    public int updateByExample(T record, Object example) {
        return getMapper().updateByExample(record, example);
    }

    @Override
    public int updateByExampleSelective(T record, Object example) {
        return getMapper().updateByExampleSelective(record, example);
    }

    @Override
    public List<T> selectByExampleAndRowBounds(Object example, RowBounds rowBounds) {
        return getMapper().selectByExampleAndRowBounds(example, rowBounds);
    }

    @Override
    public List<T> selectByRowBounds(T record, RowBounds rowBounds) {
        return getMapper().selectByRowBounds(record, rowBounds);
    }

    @Override
    public int insertList(List<? extends T> recordList) {
        return getMapper().insertList(recordList);
    }

    @Override
    public int insertUseGeneratedKeys(T record) {
        return getMapper().insertUseGeneratedKeys(record);
    }

    @Override
    public int deleteByIds(String ids) {
        return getMapper().deleteByIds(ids);
    }

    @Override
    public List<T> selectByIds(String ids) {
        return getMapper().selectByIds(ids);
    }
}
