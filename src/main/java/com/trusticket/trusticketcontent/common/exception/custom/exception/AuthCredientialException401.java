package com.trusticket.trusticketcontent.common.exception.custom.exception;


import com.trusticket.trusticketcontent.common.ErrorDefineCode;
import com.trusticket.trusticketcontent.common.exception.custom.BasicCustomException500;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 401 : 인증 실패
 */
@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class AuthCredientialException401 extends BasicCustomException500 {
    public AuthCredientialException401(ErrorDefineCode code) {
        super(code);
    }
}