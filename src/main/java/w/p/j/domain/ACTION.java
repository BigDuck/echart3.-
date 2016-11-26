package w.p.j.domain;

import java.util.HashMap;
import java.util.Map;

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