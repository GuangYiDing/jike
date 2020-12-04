package me.cocode.jike.common.cro;

/**
 * 枚举了一些常用API操作码
 */
public enum ResultCode implements BaseErrorCode {
    /*
    * 成功返回码
    *  */
    SUCCESS(200, "操作成功"),
    /*
     * 失败返回码
     *  */
    FAILED(500, "服务器内部错误"),
    /*
     * 参数检验返回码
     *  */
    VALIDATE_FAILED(404, "参数检验失败"),
    /*
     * 未授权码
     *  */
    UNAUTHORIZED(401, "暂未登录或token已经过期"),
    /*
     * 禁止码
     *  */
    FORBIDDEN(403, "没有相关权限"),
    BODY_NOT_MATCH(400,"请求的数据格式不符!"),
    SERVER_BUSY(503,"服务器正忙，请稍后再试!");
    private final long code;
    private final String message;

   ResultCode(long code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public long getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
