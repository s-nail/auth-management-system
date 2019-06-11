package com.hundsun.auth.base.dto;

public interface ResultCode extends ErrorCode {

    static final String ACK = "ACK";

    static final String NACK = "NACK";

    static final String REDIRECT = "REDIRECT";

}
