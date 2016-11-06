package w.p.j.db;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.UnsynchronizedAppenderBase;
import w.p.j.util.JdbcUtils;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Name：MyDBAppender
 * Time：2016/10/30 15:47
 * author：WPJ587
 * description：自定义
 **/

public class MyDBAppender extends UnsynchronizedAppenderBase<ILoggingEvent> {

    @Override
    protected void append(ILoggingEvent eventObject) {
        try {

            String content = eventObject.getFormattedMessage();

            System.out.println("content内容是: " + content);

            Map<String, String> map = new HashMap<String, String>();

            map.put("LOG_LEVEL", eventObject.getLevel().levelStr);

            map.put("CONTENT", content.replace("'", "''"));

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

            map.put("CREATE_DATE", sdf.format(new Date()));

            // 拼接SQL语句，然后执行
            String sql="insert into log (name ,age) values (?,?)";
            List<Object> params=new ArrayList();
            params.add(eventObject.getLevel().levelStr+":"+eventObject.getMessage());
            params.add(12);
            Thread.sleep(10000);
            JdbcUtils.updateByPreparedStatement(sql,params);

        } catch (Throwable sqle) {

            System.out.println(sqle);

        }
    }
}
