package w.p.j.domain;

import com.alibaba.fastjson.annotation.JSONField;
import w.p.j.util.FastJsonUtil;

import java.util.Date;

/**
 * Name：BaseLog
 * Time：2016/10/30 11:15
 * author：WPJ587
 * description：日志
 **/

public class BaseLog {
    /**
     * 时间
     */
    private Date date;

    /**
     * 用户名字
     */
    private String name;
    /**
     * 动作
     */
    private String ip;
    private String desc;
    private ACTION action;
    private Integer actionCode;
    public BaseLog(ACTION action, Date date, String name) {
        this.date = date;
        this.name = name;
        this.action = action;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public BaseLog(ACTION action, String name) {
        this.date = new Date();
        this.name = name;
        this.action = action;

    }

    public void setActionCode(Integer actionCode) {
        this.action = ACTION.getACTION(actionCode);
    }

    public BaseLog() {
    }


    public Integer getActionCode() {
        return action.getIndex();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JSONField(serialize = false)
    public ACTION getAction() {
        return action;
    }

    @JSONField(deserialize = false)
    public void setAction(ACTION action) {
        this.action = action;
    }

    @Override
    public String toString() {
        return "BaseLog{" +
                "name:'" + name + '\'' +
                ", action:" + action.getIndex() +
                '}';
    }



    public String toDbString() {
        return "{name:" + name + ",date:" + date + ",action:" + action.getIndex() + "}";
    }

    public static void main(String[] args) {
        BaseLog b = new BaseLog();
        b.setDate(new Date());
        b.setName("222");
        b.setAction(ACTION.GET_DATA);
        String json = FastJsonUtil.object2Json(b);
        System.out.println(json);
        b = FastJsonUtil.json2Object(json, BaseLog.class);
        System.out.println(b.toString());
    }
}
