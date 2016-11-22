package w.p.j.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import w.p.j.domain.Choice;
import w.p.j.util.ExcelImportUtil;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Name：ExcelController
 * Time：2016/10/22 23:19
 * author：WPJ587
 * description：Excel导入导出
 **/
@Controller
@RequestMapping("/excel")
public class ExcelController {

    @RequestMapping("/index")
    public String toImport() {
        return "excel";
    }

    @RequestMapping(headers = ("content-type=multipart/*"), value = "/import", method = RequestMethod.POST)
    public String importExcel(@RequestParam(value = "excelFile") MultipartFile excelFile, HttpServletRequest request) throws IOException {
        if (null == excelFile) {
            System.out.println("空");
            return null;
        }
        String path = "F:\\demo";
        //容错处理
        File dir = new File(path);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        String fileName = excelFile.getOriginalFilename();//report.xls
        String fileName2 = excelFile.getName();//excelFile
        InputStream fis = excelFile.getInputStream();
        List<Choice> data = ExcelImportUtil.parseExcel(fis);

        System.out.println(data.toString());
        return "success";
    }

    @RequestMapping("/headerPhoto")
    @ResponseBody
    public String headerPhoto(MultipartFile file) throws IOException {
        String name = file.getOriginalFilename();
        System.out.println(name);
        File file1 = new File("F:/" + name);
        file.transferTo(file1);
        return "success";
    }
}
