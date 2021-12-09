package com.TotalWork.CompleteTraining.exception;

import org.springframework.stereotype.Component;

@Component
public class CustomExceptionHandler extends Exception{
    private static final long serialVersionUID = 1l;
    private String desc;
    private String message;

    public CustomExceptionHandler(){

    }

    public CustomExceptionHandler(String desc, String message) {
        super();
        this.desc = desc;
        this.message = message;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    public static long getSerialVersionUID(){
        return serialVersionUID;
    }
}
