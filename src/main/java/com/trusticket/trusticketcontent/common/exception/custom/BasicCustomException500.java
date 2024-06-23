package com.trusticket.trusticketcontent.common.exception.custom;

import com.trusticket.trusticketcontent.common.ErrorDefineCode;
import lombok.Getter;

@Getter
public class BasicCustomException500 extends RuntimeException {
    private ErrorDefineCode code;

    public BasicCustomException500(ErrorDefineCode code) {
        super(code.getMessage());
        this.code = code;

    }
}


