package me.cocode.jike.service.impl;

import me.cocode.jike.common.service.CommonMapper;
import me.cocode.jike.common.service.impl.CommonServiceImpl;
import me.cocode.jike.dao.UsersMapper;
import me.cocode.jike.entity.Users;
import me.cocode.jike.entity.WxAccount;
import me.cocode.jike.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.net.URI;

/**
 * 2020/11/25 21:22
 *
 * @author xiaodingsiren
 */
@Service
public class UserServiceImpl extends CommonServiceImpl<Users> implements UserService  {



    @Autowired
    private UsersMapper usersMapper;

    @Override
    protected CommonMapper<Users> getMapper() {
        return usersMapper;
    }

    @Override
    public Users selectOneByName(String userName) {
        Example example = new Example(Users.class);
        example.selectProperties("id","userName","password");
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("userName", userName);
        return usersMapper.selectOneByExample(example);
    }


    @Override
    public int deleteUserById(Integer userId) {
        return usersMapper.deleteUserById(userId);
    }
}
