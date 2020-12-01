package me.cocode.jike.service;

import me.cocode.jike.common.service.CommonService;
import me.cocode.jike.entity.Users;

/**
 * 2020/11/25 21:11
 *
 * @author xiaodingsiren
 */
public interface UserService  extends CommonService<Users>{
    Users selectOneByName(String userName);
}
