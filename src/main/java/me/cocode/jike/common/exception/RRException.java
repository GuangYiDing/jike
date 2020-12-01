package me.cocode.jike.common.exception;

import lombok.Data;

/**
 * 2020/11/26 12:04
 *
 * @author xiaodingsiren
 */
@Data
public class RRException  extends RuntimeException{
    private static final long serialVersionUID = 1L;

    private String msg;
    private int code;

    public RRException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public RRException(Throwable cause, String msg) {
        super(msg,cause);
        this.msg = msg;
    }

    public RRException(String msg, int code) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    public RRException(String msg, int code, Throwable e) {
        super(msg, e);
        this.msg = msg;
        this.code = code;
    }
}
