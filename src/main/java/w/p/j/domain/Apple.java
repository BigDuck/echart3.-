package w.p.j.domain;

/**
 * Name：Apple
 * Time：2016/11/13 21:04
 * author：WPJ587
 * description：
 **/

public class Apple {
    private String name;
    private int id;
    private float price;

    public Apple(String name, int id, float price) {
        this.name = name;
        this.id = id;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
