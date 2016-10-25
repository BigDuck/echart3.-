package w.p.j.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Name：JsTreeController
 * Time：2016/10/25 22:50
 * author：WPJ587
 * description：Jstree
 **/
@Controller
@RequestMapping("/jstree")
public class JsTreeController {
    @RequestMapping("/tojstree")
    public String tojstree() {
        return "jstree";
    }
}
