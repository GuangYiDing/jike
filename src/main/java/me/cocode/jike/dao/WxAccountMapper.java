package me.cocode.jike.dao;

import me.cocode.jike.common.service.CommonMapper;
import me.cocode.jike.entity.Users;
import me.cocode.jike.entity.WxAccount;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * 2021/5/11 下午7:22
 *
 * @author xiaodingsiren
 */
public interface WxAccountMapper extends CommonMapper<WxAccount> {

    @Select("select * from wx_account where open_id=#{open_id}")
    WxAccount findByOpenId(@Param("open_id")String openId);
}
