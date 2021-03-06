package w.p.j.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import w.p.j.domain.ACTION;
import w.p.j.domain.BaseLog;
import w.p.j.domain.Exam;
import w.p.j.log.BaseLoggerDao;

import java.util.*;

/**
 * Name：BarController
 * Time：2016/10/19 23:22
 * author：WPJ587
 * description：Bar
 **/
@Controller
@RequestMapping("/echart")
public class BarController {
    @Autowired
    BaseLoggerDao baseLoggerDao;
    private static final ArrayList<Exam> p;

    static {
        p = new ArrayList<>();
        Map<String, Integer> detail = new HashMap<>();
        detail.put("优秀", 10);
        detail.put("良好", 25);
        detail.put("及格", 5);
        detail.put("不及格", 3);
        p.add(new Exam("RXK","入学考", 43, detail));
        detail = new HashMap<>();
        detail.put("优秀", 10);
        detail.put("良好", 5);
        detail.put("及格", 5);
        detail.put("不及格", 10);
        p.add(new Exam("QZK","期中考", 30, detail));
        detail = new HashMap<>();
        detail.put("优秀", 9);
        detail.put("良好", 6);
        detail.put("及格", 5);
        detail.put("不及格", 20);
        p.add(new Exam("YK","月考", 40, detail));
        detail = new HashMap<>();
        detail.put("优秀", 10);
        detail.put("良好", 15);
        detail.put("及格", 4);
        detail.put("不及格", 1);
        p.add(new Exam("QMK","期末考", 35, detail));
        detail = new HashMap<>();
        detail.put("优秀", 10);
        detail.put("良好", 10);
        detail.put("及格", 10);
        detail.put("不及格", 15);
        p.add(new Exam("JYK","结业考", 45, detail));
    }

    @RequestMapping("/bar")
    public String bar() {
        return "index";
    }

    @RequestMapping("/bar2")
    public String bar2() {
        return "bar";
    }

    @RequestMapping("/animate")
    public String animation() {
        return "animation";
    }

    @RequestMapping("/data")
    @ResponseBody
    public Object data() {
        baseLoggerDao.saveLog(new BaseLog(ACTION.LOGIN, new Date(), "吴培基"));
        System.out.println(p);
        List<Exam> res = new ArrayList<>();
        for (Exam e : p) {
            res.add(new Exam(e.getId(),e.getName(), e.getSale()));
        }
        return res;

    }

    @RequestMapping("/allData")
    @ResponseBody
    public Object allData() {
        baseLoggerDao.saveLog(new BaseLog(ACTION.GET_DATA, new Date(), "wupj"));

        return p;
    }

    @RequestMapping("/toall")
    public String toAll() {
        baseLoggerDao.saveLog(new BaseLog(ACTION.DELETE_DATA, new Date(), "wupj"));
        baseLoggerDao.addToDBLog(new BaseLog(ACTION.DELETE_DATA, new Date(), "wupj"));
        return "all";
    }

    @RequestMapping("/pie")
    @ResponseBody
    public Object getPie(@RequestParam("type") String type) {
        baseLoggerDao.saveLog(new BaseLog(ACTION.PUSH_DATA, new Date(), "吴培基"));

        Map<String, Integer> result = null;
        for (Exam ex : p) {
            if (ex.getName().equals(type)) {
                result = ex.getDetail();
                break;
            }

        }
//        if (type instanceof Integer) {
//            switch (type) {
//                case 1:
//                    result = p.get(0).getDetail();
//                    break;
//                case 2:
//                    result = p.get(1).getDetail();
//
//                    break;
//                case 3:
//                    result = p.get(2).getDetail();
//
//                    break;
//                case 4:
//                    result = p.get(3).getDetail();
//
//                    break;
//                case 5:
//                    result = p.get(4).getDetail();
//                    break;
//
//            }
//        }
        return result;
    }
}
