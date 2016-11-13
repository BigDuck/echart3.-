package w.p.j.domain;

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
//    public enum ACTION {
//        LOGIN(0), // 登录
//        LOGOUT(1), //登出
//        GETDATA(2),
//        DELETEDATA(3),
//        PUSHDATA(4);
//
//        ACTION(int i) {
//        }
//    }
    /**
     * 用户名字
     */
    private String name;
    /**
     * 动作
     */
    private ACTION action;
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

    public ACTION getAction() {
        return action;
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
        // 成员变量
        private String name;
        private int index;

        // 构造方法
        private ACTION(String name, int index) {
            this.name = name;
            this.index = index;
        }
//
//        //覆盖方法
//        @Override
//        public String toString() {
//            return this.index + "_" + this.name;
//        }
    }
}
