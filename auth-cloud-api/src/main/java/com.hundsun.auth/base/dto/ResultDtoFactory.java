package com.hundsun.auth.base.dto;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.validation.BindingResult;

/**
 * @author jiayq24996
 */
public class ResultDtoFactory {

    public ResultDtoFactory() {
    }

    public static <T> ResultDto<T> toAck(String msg) {
        return toAck(msg, null);
    }

    public static <T> ResultDto<T> toAck(String msg, T data) {
        ResultDto<T> dto = new ResultDto<T>();
        dto.setCode(ResultCode.ACK);
        dto.setMessage(msg);
        dto.setData(data);
        return dto;
    }

    public static ResultDto<String> toRedirect(String url) {
        ResultDto<String> dto = new ResultDto<String>();
        dto.setCode(ResultCode.REDIRECT);
        dto.setData(url);
        return dto;
    }

    /**
     * Description: 在controller层直接返回错误消息，避免在controller中用该方法catch异常做处理
     *
     * @param msg
     * @return
     */
    public static <T> ResultDto<T> toNack(String msg) {
        return toNack(msg, null);
    }

    /**
     * Description: 在controller层直接返回错误消息，避免在controller中用该方法catch异常做处理
     *
     * @param msg
     * @param data
     * @return
     */
    public static <T> ResultDto<T> toNack(String msg, T data) {
        ResultDto<T> dto = new ResultDto<T>();
        dto.setCode(ResultCode.NACK);
        dto.setMessage(msg);
        dto.setData(data);
        return dto;
    }

    public static ResultDto<BindingResult> toValidationError(String msg, BindingResult br) {
        ResultDto<BindingResult> dto = new ResultDto<BindingResult>();
        dto.setCode(ResultCode.VALIDATION_ERROR);
        dto.setMessage(msg);
        dto.setData(br);
        return dto;
    }

    public static ResultDto<String> toCommonError(String msg, Exception e) {
        ResultDto<String> dto = new ResultDto<String>();
        dto.setCode(ResultCode.COMMON_ERROR);
        dto.setMessage(msg == null ? e.getMessage() : msg);
        dto.setData(ExceptionUtils.getStackTrace(e));
        return dto;
    }
}
