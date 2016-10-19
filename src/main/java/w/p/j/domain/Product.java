package w.p.j.domain;

/**
 * Name：Product
 * Time：2016/10/20 0:02
 * author：WPJ587
 * description：
 **/

public class Product {
    private String name;
    private int sale;

    public Product(String name, int sale) {
        this.name = name;
        this.sale = sale;
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
