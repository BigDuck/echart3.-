package w.p.j.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import w.p.j.domain.BaseLog;
import w.p.j.log.impl.AbstractBaseLogger;

/**
 * Name：JsTreeController
 * Time：2016/10/25 22:50
 * author：WPJ587
 * description：Jstree
 **/
@Controller
@RequestMapping("/jstree")
public class JsTreeController extends AbstractBaseLogger {
    @RequestMapping("/tojstree")

    public String tojstree() {
        addToDBLog(new BaseLog(BaseLog.ACTION.GET_DATA, "pj"));
        return "jstree";
    }
}
