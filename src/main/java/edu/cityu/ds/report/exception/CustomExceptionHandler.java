package edu.cityu.ds.report.exception;

import edu.cityu.ds.report.entity.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class CustomExceptionHandler {
    @ResponseBody
    @ExceptionHandler(EntityNotExistException.class)
    public Result handleException(Exception e){
        Map<String,Object> map = new HashMap<>();
        map.put("code", ((EntityNotExistException)e).getCode());
        map.put("message",e.getMessage());

        return new Result(400, ((EntityNotExistException)e).getCode(), e.getMessage(), null);
    }
}
