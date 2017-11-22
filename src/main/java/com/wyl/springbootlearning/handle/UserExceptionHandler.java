package com.wyl.springbootlearning.handle;

import com.wyl.springbootlearning.domain.Result;
import com.wyl.springbootlearning.exception.UserException;
import com.wyl.springbootlearning.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class UserExceptionHandler {

    private final static Logger logger = LoggerFactory.getLogger(UserExceptionHandler.class);

    @ExceptionHandler(value = UserException.class)
    public Result handle(UserException e) {
        logger.info("Exception: {}",e.toString());
        return ResultUtil.error(e.getCode(), e.getMessage());
    }
}
