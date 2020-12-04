package me.cocode.jike.common.exception;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import me.cocode.jike.common.cro.BaseErrorCode;

/**
 * 2020/12/3 10:19
 * 业务异常
 * @author xiaodingsiren
 */
@Getter
@Setter
public class BizException extends  RuntimeException{
    private static final long serialVersionUID = 1L;

    protected String msg;
    protected long code;

    public BizException() {
        super();
    }

    public BizException(BaseErrorCode errorCode ){
        super(Long.toString(errorCode.getCode()));
        this.code = errorCode.getCode();
        this.msg = errorCode.getMessage();
    }

    public BizException(BaseErrorCode errorCode ,Throwable cause){
        super(Long.toString(errorCode.getCode()),cause);
        this.code = errorCode.getCode();
        this.msg = errorCode.getMessage();
    }

    public BizException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public BizException(String msg, long code) {
        super(Long.toString(code));
        this.msg = msg;
        this.code = code;
    }


    public BizException(String msg, long code,Throwable cause){
        super(Long.toString(code), cause);
        this.code = code;
        this.msg = msg;
    }

    @Override
    public Throwable fillInStackTrace() {
        return this;
    }
}
