package me.cocode.jike.security;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @author guangyi
 */
public class JwtToken implements AuthenticationToken {

    /**
     * 秘钥
     */
    private  String token;

    public JwtToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "JwtToken{" +
                "token='" + token + '\'' +
                '}';
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
