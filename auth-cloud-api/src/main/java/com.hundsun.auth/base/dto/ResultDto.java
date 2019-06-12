package com.hundsun.auth.base.dto;

import lombok.*;

import java.io.Serializable;


/**
 * @author jiayq24996
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResultDto<T> implements Serializable {
    /**
     * 0:failed（默认）
     * 1:success（默认）
     */
    private String code;
    private String message;
    private T data;

    /**
     * Description: whether this is non business error
     * @return
     */
    public boolean isNonBizError() {
        return ResultCode.SESSION_TIME_OUT.equals(code) || ResultCode.COMMON_ERROR.equals(code);
    }
}
