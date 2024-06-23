package com.trusticket.trusticketcontent.common.exception.custom.exception;


import com.trusticket.trusticketcore.common.ErrorDefineCode;
import com.trusticket.trusticketcore.common.exception.custom.BasicCustomException500;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;



/**
 * 412 : 요청이 조건에 부합하지 않는 경우 (그룹의 최대 인원 수 초과 등..)
 */
@ResponseStatus(HttpStatus.PRECONDITION_FAILED)
public class PreconditionFailException412 extends BasicCustomException500 {
    public PreconditionFailException412(ErrorDefineCode code) {
        super(code);
    }
}