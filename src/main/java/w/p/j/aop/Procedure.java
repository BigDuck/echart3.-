/*
 * ©2016 wupjhy.cn.  All rights reserved.
 */

package w.p.j.aop;

import w.p.j.domain.ACTION;

import java.lang.annotation.*;

/**
 * Procedure declaration of REST API.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface Procedure {
    String description() default "";

    ACTION action() default ACTION.GET_DATA;

}
