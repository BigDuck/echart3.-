package w.p.j.domain;

import com.alibaba.fastjson.annotation.JSONField;
import w.p.j.util.FastJsonUtil;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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
    private ACTION action;
    private Integer actionCode;
    public BaseLog(ACTION action, Date date, String name) {
        this.date = date;
        this.name = name;
        this.action = action;
    }

    public BaseLog(ACTION action, String name) {
        this.date = new Date();
        this.name = name;
        this.action = action;

    }

    public BaseLog() {
    }

    public void setActionCode(Integer actionCode) {
        this.action = ACTION.getACTION(actionCode);
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
                ", action:" + action.index +
                '}';
    }

    public enum ACTION {

        LOGIN("登录", 1),
        LOGOUT("登出", 2),
        GET_DATA("获取数据", 3),
        DELETE_DATA("删除数据", 4),
        PUSH_DATA("更新数据", 5),
        VIEW_PAGE("訪問頁面", 6);
        private static final Map<Integer, ACTION> CODE_MAP = new HashMap<Integer, ACTION>();

        static {
            for (ACTION typeEnum : ACTION.values()) {
                CODE_MAP.put(typeEnum.getIndex(), typeEnum);
            }
        }
        // 成员变量
        private String name;
        private int index;

        public int getIndex() {
            return index;
        }

        public String getName() {
            return name;
        }

        public static ACTION getACTION(Integer code) {
            return CODE_MAP.get(code);
        }
        // 构造方法
        ACTION(String name, int index) {
            this.name = name;
            this.index = index;
        }

    }

    public String toDbString() {
        return "{name:" + name + ",date:" + date + ",action:" + action.index + "}";
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
