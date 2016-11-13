package w.p.j.log.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import w.p.j.domain.BaseLog;
import w.p.j.log.BaseLoggerDao;

/**
 * Name：BaseLoggerDaoImpl
 * Time：2016/10/30 11:31
 * author：WPJ587
 * description：基础日志实现类
 **/

public abstract class AbstractBaseLogger implements BaseLoggerDao<BaseLog> {
    private Logger actionLogger = LoggerFactory.getLogger("action");
    private Logger dbLogger = LoggerFactory.getLogger("asyncLog");
    @Override
    public void saveLog(BaseLog baseLog) {
        actionLogger.info(baseLog.toString());
    }

    @Override
    public void addToDBLog(BaseLog baseLog) {
        dbLogger.info(baseLog.toString());
    }
}
