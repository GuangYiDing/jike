package me.cocode.jike.service.impl;

import me.cocode.jike.common.service.CommonMapper;
import me.cocode.jike.common.service.impl.CommonServiceImpl;
import me.cocode.jike.dao.WxAccountMapper;
import me.cocode.jike.entity.WxAccount;
import me.cocode.jike.service.WxAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 2021/5/11 下午7:25
 *
 * @author xiaodingsiren
 */
@Service
public class WxAccountServiceIpml extends CommonServiceImpl<WxAccount> implements WxAccountService {

    @Autowired
    private WxAccountMapper wxAccountMapper;

    @Override
    protected CommonMapper<WxAccount> getMapper() {
        return wxAccountMapper;
    }

    @Override
    public WxAccount findByOpenId(String openId) {
        return wxAccountMapper.findByOpenId(openId);
    }
}
