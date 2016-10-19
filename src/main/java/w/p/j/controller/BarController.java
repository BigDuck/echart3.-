package w.p.j.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import w.p.j.domain.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Name：BarController
 * Time：2016/10/19 23:22
 * author：WPJ587
 * description：Bar
 **/
@Controller
@RequestMapping("/echart")
public class BarController {
    @RequestMapping("/bar")
    public String bar() {
        return "index";
    }

    @RequestMapping("/data")
    @ResponseBody
    public Object data() {
        List<Product> p = new ArrayList<>();
        p.add(new Product("衬衫", 20));
        p.add(new Product("雪纺衫", 30));
        p.add(new Product("羊毛衫", 40));
        p.add(new Product("裤子", 50));
        p.add(new Product("高跟鞋", 35));
        p.add(new Product("球鞋", 45));
        p.add(new Product("运动靴", 54));
        return p;

    }
}
