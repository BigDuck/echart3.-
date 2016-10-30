package w.p.j.db;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.db.DBAppenderBase;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * Name：MyDBAppender
 * Time：2016/10/30 15:47
 * author：WPJ587
 * description：自定义
 **/

public class MyDBAppender extends DBAppenderBase<ILoggingEvent> {
    protected String insertPropertiesSQL;
    protected String insertExceptionSQL;
    protected String insertSQL;

    @Override
    protected Method getGeneratedKeysMethod() {
        return null;
    }

    @Override
    protected String getInsertSQL() {
        return "insert";
    }

    @Override
    protected void subAppend(ILoggingEvent eventObject, Connection connection, PreparedStatement statement) throws Throwable {

    }

    @Override
    protected void secondarySubAppend(ILoggingEvent eventObject, Connection connection, long eventId) throws Throwable {

    }
}
