package me.cocode.jike.security;

import me.cocode.jike.common.exception.RRException;
import me.cocode.jike.dao.UsersMapper;
import me.cocode.jike.entity.Users;
import me.cocode.jike.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author guangyi
 */
@Service
public class MyRealm extends AuthorizingRealm {

    private static final Logger logger = LoggerFactory.getLogger(MyRealm.class);

    @Autowired
    private UsersMapper service;


    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    /**
     * 只有当需要检测用户权限的时候才会调用此方法，例如checkRole,checkPermission之类的
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        logger.info("鉴权: doGetAuthorizationInfo==> " + principals.toString());
        Integer                 userId            = JwtUtils.getUserId(principals.toString());
        Users user              = service.selectByPrimaryKey(userId);
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.addRole(user.getRole());
        Set<String> permission = new HashSet<>(Arrays.asList(user.getPermission().split(",")));
        authorizationInfo.addStringPermissions(permission);
        return authorizationInfo;
    }

    /**
     * 默认使用此方法进行用户名正确与否验证，错误抛出异常即可。
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken auth) throws AuthenticationException {
        logger.info("认证: doGetAuthenticationInfo==>" + auth);
        String  token  = (String) auth.getCredentials();
        Integer userId = JwtUtils.getUserId(token);
        if (userId == null) {
            throw new AuthenticationException("token invalid");
        }
        Users user = service.selectByPrimaryKey(userId);
        if (user == null) {
            throw new AuthenticationException("user don't existed!");
        }
        if (!JwtUtils.verify(token, userId, user.getPassword())) {
            throw new AuthenticationException("username or password incorrect!");
        }
        return new SimpleAuthenticationInfo(token, token, "my_realm");
    }
}
