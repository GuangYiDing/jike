package me.cocode.jike.common.cro;

/**
 * 通用返回对象
 */
public class R<T> {
    private long code;
    private String message;
    private T data;

    protected R() {
    }

    protected R(long code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 成功返回结果
     *
     * @param data 获取的数据
     */
    public static <T> R<T> success(T data) {
        return new R<T>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data);
    }

    /**
     * 成功返回结果
     *
     * @param data 获取的数据
     * @param  message 提示信息
     */
    public static <T> R<T> success(T data, String message) {
        return new R<T>(ResultCode.SUCCESS.getCode(), message, data);
    }

    /**
     * 失败返回结果
     * @param errorCode 错误码
     */
    public static <T> R<T> failed(BaseErrorCode errorCode) {
        return new R<T>(errorCode.getCode(), errorCode.getMessage(), null);
    }

    /**
     * 失败返回结果
     * @param message 提示信息
     */
    public static <T> R<T> failed(String message) {
        return new R<T>(ResultCode.FAILED.getCode(), message, null);
    }

    /**
     * 失败返回结果
     */
    public static <T> R<T> failed() {
        return failed(ResultCode.FAILED);
    }

    /**
     * 参数验证失败返回结果
     */
    public static <T> R<T> validateFailed() {
        return failed(ResultCode.VALIDATE_FAILED);
    }

    /**
     * 参数验证失败返回结果
     * @param message 提示信息
     */
    public static <T> R<T> validateFailed(String message) {
        return new R<T>(ResultCode.VALIDATE_FAILED.getCode(), message, null);
    }

    /**
     * 未登录返回结果
     */
    public static <T> R<T> unauthorized(T data) {
        return new R<T>(ResultCode.UNAUTHORIZED.getCode(), ResultCode.UNAUTHORIZED.getMessage(), data);
    }

    /**
     * 未授权返回结果
     */
    public static <T> R<T> forbidden(T data) {
        return new R<T>(ResultCode.FORBIDDEN.getCode(), ResultCode.FORBIDDEN.getMessage(), data);
    }

    /**
     * 请求的数据格式不符
     */
    public static <T> R<T> bodyNotMatch(T data) {
        return new R<T>(ResultCode.BODY_NOT_MATCH.getCode(), ResultCode.BODY_NOT_MATCH.getMessage(), data);
    }

    /**
     * 服务器正忙
     */
    public static <T> R<T> serverBusy(T data) {
        return new R<T>(ResultCode.SERVER_BUSY.getCode(), ResultCode.SERVER_BUSY.getMessage(), data);
    }

    public static <T> R<T> failed(long code, String msg) {
        return new R<T>(code,msg,null);
    }


    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "R{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
