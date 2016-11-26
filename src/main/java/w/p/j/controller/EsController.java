package w.p.j.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Name：EsController
 * Time：2016/11/23 23:05
 * author：WPJ587
 * description：es 测试
 **/
@Controller
@RequestMapping("/es")
public class EsController {
    //    @Autowired
//    private ElasticsearchTemplate elasticsearchTemplate;
    @RequestMapping("/add")
    public void add() {
//        List<IndexQuery> indexQueries = new ArrayList<IndexQuery>();
//        String documentId = "123456";
//        BaseLog baseLog=new BaseLog();
//        baseLog.setAction(BaseLog.ACTION.GET_DATA);
//        baseLog.setName("吴培基");
//        baseLog.setDate(new Date());
//        IndexQuery indexQuery1 = new IndexQueryBuilder().withObject(baseLog).build();
//        indexQueries.add(indexQuery1);
//        elasticsearchTemplate.bulkIndex(indexQueries);

    }
}
