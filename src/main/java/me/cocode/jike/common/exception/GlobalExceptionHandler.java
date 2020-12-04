package me.cocode.jike.common.exception;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import me.cocode.jike.common.cro.R;
import me.cocode.jike.common.cro.ResultCode;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.tomcat.util.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 2020/12/2 23:04
 * 全局异常处理
 * @author xiaodingsiren
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BizException.class)
    public R<String> exceptionHandler(HttpServletRequest req, BizException e){
        log.error("发生业务异常!原因是:"+e.getMessage());
        return R.failed(e.getCode(),e.getMsg());
    }


//    @ExceptionHandler(NullPointerException.class)
//    public R<String> exceptionHandler(HttpServletRequest req, NullPointerException e){
//        log.error("空指针异常!原因是"+e);
//        return R.failed(ResultCode.BODY_NOT_MATCH);
//    }


//    @ExceptionHandler(Exception.class)
//    @ResponseBody
//    public R<String> exceptionHandler(HttpServletRequest req, Exception e){
//        log.error("其他异常!原因是"+e);
//        return R.failed(ResultCode.FAILED);
//    }


    @ExceptionHandler(AuthenticationException.class)
    public R<String> exceptionHandler(AuthenticationException e,HttpServletResponse response){
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        try {
            PrintWriter writer = response.getWriter();
            writer.write(JSON.toJSONString(R.failed(e.getMessage())));
            writer.flush();
            writer.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return R.failed(e.getMessage());
    }
}
