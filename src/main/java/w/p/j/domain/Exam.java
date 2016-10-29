package w.p.j.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Map;

/**
 * Name：Product
 * Time：2016/10/20 0:02
 * author：WPJ587
 * description： 考试
 **/
@JsonSerialize(include= JsonSerialize.Inclusion.NON_NULL)//自动忽略空字段 之后做接口
public class Exam {
    private String id;
    private String name;
    private int sale;
    private Map<String,Integer> detail;
    public Exam(String id,String name, int sale) {
        this.name = name;
        this.sale = sale; this.id=id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setDetail(Map detail) {
        this.detail = detail;
    }

    public Map getDetail() {
        return detail;
    }

    public Exam(String id,String name, int sale, Map<String, Integer> detail) {
        this.name = name;
        this.sale = sale;
        this.detail = detail;
        this.id=id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSale() {
        return sale;
    }

    public void setSale(int sale) {
        this.sale = sale;
    }
}
