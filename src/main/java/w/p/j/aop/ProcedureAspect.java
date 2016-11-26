/*
 * ©2016 wupjhy.cn.  All rights reserved.
 */

package w.p.j.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import w.p.j.domain.BaseLog;
import w.p.j.log.BaseLoggerDao;
import w.p.j.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.UUID;

@Component
@Aspect
public class ProcedureAspect {
    @Autowired
    BaseLoggerDao baseLoggerDao;
    @Autowired
    private HttpServletResponse response;

    private Logger logger = LoggerFactory.getLogger(ProcedureAspect.class);

    /**
     * 获取注解中对方法的描述信息 用于Controller层注解
     *
     * @param joinPoint 切点
     * @return 方法描述
     * @throws Exception
     */
    public static BaseLog getControllerMethodDescription(JoinPoint joinPoint) throws Exception {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        BaseLog baseLog = new BaseLog();
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length) {
                    baseLog.setDesc(method.getAnnotation(Procedure.class).description());
                    baseLog.setAction(method.getAnnotation(Procedure.class).action());
                    baseLog.setName(request.getRemoteHost());
                    break;
                }
            }
        }
        return baseLog;
    }

    @Pointcut("execution(* w.p.j.aop.*.*(..)) ")
    public void targetMethods() {
    }

    @Before("@annotation(w.p.j.aop.Procedure)")
    public void preHandle(JoinPoint joinPoint) throws IOException {

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        System.out.println("请求url:" + request.getRequestURI() + session.getAttribute("role"));
        if (session.getAttribute("role") == null && request.getRequestURI().contains("/admin")) {
            System.out.println(request.getContextPath());
            response.sendRedirect(request.getContextPath() + "/login");
        }


        //读取session中的用户
        //	logger.info("name---------->"+ SecurityTools.getUserName());
        //请求的IP

        logger.error("请求方法:" + (joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()"));
        StringBuffer params = new StringBuffer();
        for (Object o : joinPoint.getArgs()) {
            if (StringUtils.isNoneEmtryAndNull(o)) {
                params.append("-" + o.toString());
            }
            logger.error("参数:{}", o);
        }
    }

    @AfterReturning(
            value = "w.p.j.aop.Procedure",
            pointcut = "@annotation(w.p.j.aop.Procedure)",
            returning = "retVal"
    )
    public void postHandle(JoinPoint joinPoint, Object retVal) throws Exception {
        logger.info("Aspect :: postHandle, " + joinPoint);
        BaseLog baseLog = getControllerMethodDescription(joinPoint);
        baseLoggerDao.addToDBLog(baseLog);
    }

    @Around("@annotation(w.p.j.aop.Procedure)")
    public Object handle(ProceedingJoinPoint pjp) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes()).getRequest();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ");
        Calendar ca = Calendar.getInstance();
        String operDate = df.format(ca.getTime());
        logger.error(operDate + "------------");
        logger.error("Aspect :: around - start");
        Object[] args;
        try {
            args = pjp.getArgs();
            return args == null ? pjp.proceed() : pjp.proceed(args);
        } catch (Throwable e) {
            logger.error("Aspect :: handleException");
            int statusCode = 500;
            String statusMessage = "unknown";
            if (e instanceof ProcedureException) {
                statusCode = ((ProcedureException) e).getStatusCode();
                statusMessage = ((ProcedureException) e).getStatusMessage();
            } else if (e instanceof IllegalArgumentException) {
                statusCode = 400;
                statusMessage = "Invalid parameter";
            }
            Output<Object> error = new Output<Object>(UUID.randomUUID().toString(), statusCode, statusMessage);
            return error;
        } finally {
            logger.error("Aspect :: around - end");
        }
    }

}
