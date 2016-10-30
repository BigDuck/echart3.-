package w.p.j.log;

import w.p.j.domain.BaseLog;

/**
 * Created by WPJ587 on 2016/10/30.
 */
public interface BaseLoggerDao<T extends BaseLog> {
    void saveLog(T t);
}
