package com.wql.servicebase.config.exceptionhandler;

import com.wql.utils.ExceptionUtil;
import com.wql.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * 同意异常处理类
 * @author wql
 * @version 1.0
 * @date 2020/4/14 20:53
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    //全局异常
    //指定出现哪种异常会调用
    @ExceptionHandler(Exception.class) //Exception类就是全部
    @ResponseBody
    public R error(Exception e){
        e.printStackTrace();
        log.error(ExceptionUtil.getMessage(e));
        return R.error().message("执行全局异常处理...");
    }

    /**
     * 特定异常优先级高高于全局异常，一般会先找特定异常，然后再找全局异常
     */

    //特定异常处理  指定类即可
    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    public R error(ArithmeticException e){
        e.printStackTrace();
        log.error(ExceptionUtil.getMessage(e));
        return R.error().message("执行了ArithmeticException异常处理...");
    }

    //自定义异常处理
    //1.创建自定义异常类(MyException.class) 继承 RuntimeException 类 后续看MyException中注释
    //2.自定义异常处理方法
    //3.在try catch 捕捉异常时  throw new MyException(传入状态码code,传入信息msg),实例见EduTeacherController pageSelect中
    @ExceptionHandler
    @ResponseBody
    public R error(MyException e){
        e.printStackTrace();
        log.error(ExceptionUtil.getMessage(e));
        return R.error().code(e.getCode()).message(e.getMsg());
    }
}
