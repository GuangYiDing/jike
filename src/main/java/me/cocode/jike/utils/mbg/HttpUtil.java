package me.cocode.jike.utils.mbg;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.URI;
/**
 * 2021/5/11 下午3:40
 *
 * @author xiaodingsiren
 */
public enum  HttpUtil {
    ;
    /**
     * 根据url和请求参数获取URI
     */
    public static URI getURIwithParams(String url, MultiValueMap<String, String> params) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url).queryParams(params);
        return builder.build().encode().toUri();
    }

}
