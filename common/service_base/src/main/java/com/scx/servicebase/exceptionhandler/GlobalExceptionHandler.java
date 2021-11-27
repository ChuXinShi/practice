package com.scx.servicebase.exceptionhandler;


import com.scx.commonutils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @auther scx
 * @date 2021/7/24 - 16:13
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    //指定出现什么异常执行这个方法

    //全局异常
    @ExceptionHandler(Exception.class)
    @ResponseBody//返回数据
    public R error(Exception e) {
        e.printStackTrace();
        return R.error().message("执行了全局异常处理...  ");
    }

    //特定异常
    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody//返回数据
    public R error(ArithmeticException e) {
        e.printStackTrace();
        return R.error().message("执行了ArithmeticException异常处理...  ");
    }

    //自定义异常
    @ExceptionHandler(ScxException.class)
    @ResponseBody//返回数据
    public R error(ScxException e) {
        log.error(e.getMessage());
        e.printStackTrace();
        return R.error().code(e.getCode()).message(e.getMsg());
    }

}
