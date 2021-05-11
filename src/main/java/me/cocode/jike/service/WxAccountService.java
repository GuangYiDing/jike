package me.cocode.jike.service;

import me.cocode.jike.common.service.CommonService;
import me.cocode.jike.entity.Users;
import me.cocode.jike.entity.WxAccount;
import org.springframework.stereotype.Service;

/**
 * 2021/5/11 下午7:24
 *
 * @author xiaodingsiren
 */

public interface WxAccountService extends CommonService<WxAccount> {
    WxAccount findByOpenId(String openId);
}
