package w.p.j.db;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.UnsynchronizedAppenderBase;
import w.p.j.domain.BaseLog;
import w.p.j.util.FastJsonUtil;
import w.p.j.util.JdbcUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

//            Map<String, String> map = new HashMap<String, String>();
//
//            map.put("LOG_LEVEL", eventObject.getLevel().levelStr);
//
//            map.put("CONTENT", content.replace("'", "''"));

            //    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

            //    map.put("CREATE_DATE", sdf.format(new Date()));
            BaseLog baseLog;
            System.out.println(content);
            baseLog = FastJsonUtil.json2Object(content, BaseLog.class);

            // 拼接SQL语句，然后执行
            String sql = "insert into BaseLog (date,name,action) values (?,?,?)";
            List<Object> params = new ArrayList();
            params.add(new Date());
            params.add(baseLog.getName());
            System.out.println(baseLog.getAction());
            params.add(baseLog.getActionCode());
            JdbcUtils.updateByPreparedStatement(sql, params);
        } catch (Exception e) {
            e.printStackTrace();


        }
    }
}

