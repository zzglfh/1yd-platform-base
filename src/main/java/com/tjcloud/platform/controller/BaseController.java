package com.tjcloud.platform.controller;

import com.tjcloud.exception.CommonException;
import com.tjcloud.exception.ExceptionCode;
import com.tjcloud.exception.model.ErrorModel;
import com.tjcloud.platform.component.BaseComponent;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * 该类为所有API Controller的父类，用以统一处理异常
 *
 * @author guo, Yan.Xia
 * @since Aug 19, 2014 12:03:11 PM
 */
public abstract class BaseController extends BaseComponent {

    private ObjectMapper jsonMapper = new ObjectMapper();

    private StringWriter errors;

    /**
     * handle common exception
     *
     * @param ex
     * @param httpServletResponse
     * @return
     */
    @ExceptionHandler(CommonException.class)
    public ErrorModel handleException(CommonException ex,
                                      HttpServletResponse httpServletResponse) {
        errors = new StringWriter();
        ex.printStackTrace(new PrintWriter(errors));
        logger.error(String.format("happend something common exception[%s]", errors));

        ErrorModel exceptionResult = new ErrorModel(ex.getErrCode(), ex.getMessage());
        httpServletResponse.setStatus(HttpStatus.BAD_REQUEST.value());

        return exceptionResult;
    }

    /**
     * handle Unkonw exception
     *
     * @param ex
     * @param httpServletResponse
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ErrorModel handleException(Exception ex,
                                      HttpServletResponse httpServletResponse) {
        errors = new StringWriter();
        ex.printStackTrace(new PrintWriter(errors));
        logger.error(String.format("happend something unkonw exception[%s]", errors));

        ErrorModel exceptionResult = new ErrorModel(ExceptionCode.UNKNOWN.getCode(), ex.getMessage());
        httpServletResponse.setStatus(HttpStatus.BAD_REQUEST.value());

        return exceptionResult;
    }

}
