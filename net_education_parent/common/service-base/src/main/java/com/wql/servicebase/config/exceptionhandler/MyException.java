package com.wql.servicebase.config.exceptionhandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 自定义异常类  继承 RuntimeException 类
 * 定义状态码code和msg异常信息
 * 注解生成有参(AllArgsConstructor)无参(NoArgsConstructor)构造(lombok生成)
 * @author wql
 * @version 1.0
 * @date 2020/4/14 21:40
 */
@Data
@AllArgsConstructor  //有参构造方法注解
@NoArgsConstructor  ///无参构造方法注解
public class MyException extends RuntimeException {

    private Integer code;//状态码

    private String msg;//异常信息

//    public MyException(){}
}
