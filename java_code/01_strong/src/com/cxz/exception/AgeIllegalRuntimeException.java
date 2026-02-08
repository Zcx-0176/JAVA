package com.cxz.exception;

public class AgeIllegalRuntimeException extends RuntimeException {
    public AgeIllegalRuntimeException() {  //无参构造器
    }
    public AgeIllegalRuntimeException(String age) {  //有参构造器
        super(age);
    }
}
