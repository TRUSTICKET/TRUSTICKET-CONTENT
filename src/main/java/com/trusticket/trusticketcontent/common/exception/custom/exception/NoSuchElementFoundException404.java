package com.trusticket.trusticketcontent.common.exception.custom.exception;


import com.trusticket.trusticketcontent.common.ErrorDefineCode;
import com.trusticket.trusticketcontent.common.exception.custom.BasicCustomException500;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 404 : 해당 자원을 찾을 수 없는 경우
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoSuchElementFoundException404 extends BasicCustomException500 {
    public NoSuchElementFoundException404(ErrorDefineCode code) {
        super(code);
    }
}