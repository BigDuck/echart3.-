package w.p.j.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import w.p.j.aop.Procedure;
import w.p.j.log.BaseLoggerDao;

/**
 * Name：JsTreeController
 * Time：2016/10/25 22:50
 * author：WPJ587
 * description：Jstree
 **/
@Controller
@RequestMapping("/jstree")
public class JsTreeController {
    @Autowired
    BaseLoggerDao baseLoggerDao;
    @RequestMapping("/tojstree")
    @Procedure(description = "加载树")
    public String tojstree() {
        return "jstree";
    }
}
