package w.p.j.domain;

import java.util.Map;

/**
 * Name：Choice
 * Time：2016/10/22 23:32
 * author：WPJ587
 * description：选择题目
 **/

public class Choice {
    /**
     * 题目
     */
    private String title;
    /**
     * 选项
     */
    private Map<String,Object> option;
    /**
     * 正确答案
     */
    private String right;
    /**
     * 解析
     */
    private String analysis;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Map<String, Object> getOption() {
        return option;
    }

    public void setOption(Map<String, Object> option) {
        this.option = option;
    }

    public String getRight() {
        return right;
    }

    public void setRight(String right) {
        this.right = right;
    }

    public String getAnalysis() {
        return analysis;
    }

    public void setAnalysis(String analysis) {
        this.analysis = analysis;
    }

    public Choice() {
    }

    public Choice(String title, Map<String, Object> option, String right, String analysis) {
        this.title = title;
        this.option = option;
        this.right = right;
        this.analysis = analysis;
    }

    @Override
    public String toString() {
        return "Choice{" +
                "title='" + title + '\'' +
                ", option=" + option +
                ", right='" + right + '\'' +
                ", analysis='" + analysis + '\'' +
                '}';
    }
}
