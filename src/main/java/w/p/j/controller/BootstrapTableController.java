package w.p.j.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import w.p.j.domain.ACTION;
import w.p.j.domain.Apple;
import w.p.j.domain.BaseLog;
import w.p.j.log.BaseLoggerDao;
import w.p.j.util.FastJsonUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 * Name：BootstrapTableController
 * Time：2016/11/13 20:51
 * author：WPJ587
 * description：
 **/
@Controller
@RequestMapping("/bttable")
public class BootstrapTableController {
    @Autowired
    BaseLoggerDao baseLoggerDao;
    @Autowired
    private HttpServletRequest httpServletRequest;
    @Autowired
    HttpServletResponse httpServletResponse;

    @RequestMapping("/table")
    public String table() {
        baseLoggerDao.addToDBLog(new BaseLog(ACTION.VIEW_PAGE, httpServletRequest.getRemoteUser()));
        return "table";
    }

    @RequestMapping("/data")
    @ResponseBody
    public Object data() {
        baseLoggerDao.addToDBLog(new BaseLog(ACTION.GET_DATA, httpServletRequest.getLocalAddr()));
        List<Apple> appleList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Random r = new Random();
            appleList.add(new Apple("苹果" + i + "号", i, r.nextFloat() * 100));
        }
        return appleList;
    }

    @RequestMapping("/dataByResp")
    public void dataByResp(


    ) throws InterruptedException {
        List<Apple> appleList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Random r = new Random();
            appleList.add(new Apple("苹果" + i + "号", i, r.nextFloat() * 100));
        }

        responseOutWithJson(httpServletResponse, appleList);
    }

    /**
     * 以JSON格式输出
     *
     * @param response
     */
    protected void responseOutWithJson(HttpServletResponse response,
                                       List<Apple> appleList) {
        Map<String, Object> totalAndRows = new HashMap<>();

        totalAndRows.put("total", 100);
        totalAndRows.put("rows", appleList);

        //将实体对象转换为JSON Object转换
        String jsonString = FastJsonUtil.object2Json(totalAndRows);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.append(jsonString);
            //  Thread.sleep(1000);
            baseLoggerDao.addToDBLog(new BaseLog(ACTION.GET_DATA, jsonString));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }
}
