package w.p.j.log.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import w.p.j.domain.BaseLog;
import w.p.j.log.BaseLoggerDao;
import w.p.j.util.FastJsonUtil;

/**
 * Name：BaseLoggerDaoImpl
 * Time：2016/10/30 11:31
 * author：WPJ587
 * description：基础日志实现类
 **/
@Repository("baseLoggerDao")
public class BaseLoggerDaoImpl implements BaseLoggerDao<BaseLog> {
    private Logger actionLogger = LoggerFactory.getLogger("action");
    private Logger dbLogger = LoggerFactory.getLogger("asyncLog");
    @Override
    public void saveLog(BaseLog baseLog) {
        actionLogger.info(baseLog.toString());
    }

    @Override
    public void addToDBLog(BaseLog baseLog) {
        String json = FastJsonUtil.object2Json(baseLog);
        dbLogger.info(json);
    }
}
