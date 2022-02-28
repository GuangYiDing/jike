package me.cocode.jike.dao;

import me.cocode.jike.common.service.CommonMapper;
import me.cocode.jike.entity.Users;
import me.cocode.jike.entity.WxAccount;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UsersMapper extends CommonMapper<Users> {

    @Delete("delete from users where users.id =#{id}")
    int deleteUserById(@Param("id") Integer id);
}