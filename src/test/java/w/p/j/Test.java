package w.p.j;

import org.apache.commons.collections.map.HashedMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Name：Test
 * Time：2016/11/16 22:45
 * author：WPJ587
 * description：
 **/

public class Test {
    public static void main(String[] args) {
        List<Map<String, Object>> list = new ArrayList<>();
        List<String> type = new ArrayList<>();
        type.add("LOGIN");
        type.add("LOGOUT");
        List<String> showTypeList = new ArrayList<>();
        showTypeList.add("2016-11-09");
        showTypeList.add("2016-11-10");
        showTypeList.add("2016-11-11");
        Map<String, Object> map = new HashMap();
        map.put("showType", "2016-11-09");
        map.put("type", "LOGIN");
        map.put("times", 2);
        list.add(map);
        map = new HashMap();
        map.put("showType", "2016-11-09");
        map.put("type", "LOGOUT");
        map.put("times", 32);
        list.add(map);
        map = new HashMap();
        map.put("showType", "2016-11-10");
        map.put("type", "LOGOUT");
        map.put("times", 12);
        list.add(map);
        map = new HashMap();
//        map.put("showType", "2016-11-11");
//        map.put("type", "LOGOUT");
//        map.put("times", 21);
//        list.add(map);
        map = new HashMap();
        map.put("showType", "2016-11-11");
        map.put("type", "LOGIN");
        map.put("times", 8);
        list.add(map);

        // 创建集合容器
        List<Map<String, List<Object>>> tempList = new ArrayList<>();
        for (int i = 0; i < type.size(); i++) {
            Map<String, List<Object>> te = new HashedMap();
            te.put(type.get(i), new ArrayList<>());
            tempList.add(te);
        }

//        for (int i = 0; i < showTypeList.size(); i++) {
//            for (int j = 0; j < list.size(); j++) {
//                if(showTypeList.get(i).equals(list.get(j).get("showType"))){
//                    if(list.get(j).get("type").equals("LOGIN")){
//                        login.add(list.get(j).get("times"));
//                        break;
//                    }else {
//                        if(j==list.size()-1){
//                            login.add(0);
//                        }
//                    }
//                }else {
//                    if(j==list.size()-1){
//                        login.add(0);
//                    }
//                }
//            }
//        }
//        for (int i = 0; i < showTypeList.size(); i++) {
//            for (int j = 0; j < list.size(); j++) {
//                if(showTypeList.get(i).equals(list.get(j).get("showType"))){
//                    if(list.get(j).get("type").equals("LOGOUT")){
//                        logout.add(list.get(j).get("times"));
//                        break;
//                    }else {
//                        if(j==list.size()-1){
//                            logout.add(0);
//                        }
//                    }
//                }
//                else {
//                    if(j==list.size()-1){
//                        logout.add(0);
//                    }
//                }
//            }
//        }


//        for (int i=0;i<showTypeList.size();i++){
//            for (int j = 0; j < list.size(); j++) {
//                if(showTypeList.get(i).equals(list.get(j).get("showType"))){
//                    if(list.get(j).get("type").equals("LOGIN")){
//                        login.add(list.get(j).get("times"));
//                    }else if(j==list.size()-1){
//                        login.add(0);
//                    }
//                    if(list.get(j).get("type").equals("LOGOUT")){
//                        logout.add(list.get(j).get("times"));
//                    }else if(j==list.size()-1){
//                        logout.add(0);
//                    }
//                }
//            }
//        }
//        for (String typeItem : type) {
//            System.out.println(getArr(showTypeList, list, typeItem).toString());
//        }
//        Client client = new NodeClient();
//        ElasticsearchTemplate elasticsearchTemplate=new ElasticsearchTemplate();

//        for (int i=0;i<showTypeList.size();i++){ //2016
//            for (Map<String,Object> item:list){
//                if(showTypeList.get(i).equals(item.get("showType"))){
//                    String key="";
//                    int index=0;
//                    for(Map<String,List<Object>> listItem:tempList){
//                        index++;
//                        Iterator it = listItem.entrySet().iterator();
//                        Map.Entry entry = (java.util.Map.Entry)it.next();
//                        if(entry.getKey().equals(item.get("type"))){
//                            key= (String) entry.getKey();
//                        }
//                    }
//                    Map<String,List<Object>> te=new HashedMap();
//                    for (Map<String,List<Object>> teItem:tempList){
//                        Iterator it = teItem.entrySet().iterator();
//                        Map.Entry entry = (java.util.Map.Entry)it.next();
//                        if(entry.getKey().equals(key)){
//                            te=teItem;
//                        }
//
//                    }
//                    for (int j=0;j<type.size();j++){
//                        if(item.get("type").toString().equals(type.get(i))){
//                            List<Object> items= te.get(key);// 得到本来的集合
//                            items.add(item.get("times"));
//                            te.put(key,items);
//                        }else {
//                            for (int k = 0; k < list.size(); k++) {
//                                if(!list.get(k).get("showType").equals(showTypeList.get(i))){
//                                    if(k==list.size()){
//                                        List<Object> items= te.get(key);// 得到本来的集合
//                                        items.add(0);
//                                        te.put(key,items);
//                                    }
//                                }
//                            }
//
//                        }
//
//                    }
//                    tempList.add(index,te);
//                }
//            }
//        }

    }

    private static List<Object> getArr(List<String> showTypeList, List<Map<String, Object>> list, String type) {
        List<Object> tempList = new ArrayList();
        for (int i = 0; i < showTypeList.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (showTypeList.get(i).equals(list.get(j).get("showType"))) {
                    if (list.get(j).get("type").equals(type)) {
                        tempList.add(list.get(j).get("times"));
                        break;
                    } else {
                        if (j == list.size() - 1) {
                            tempList.add(0);
                        }
                    }
                } else {
                    if (j == list.size() - 1) {
                        tempList.add(0);
                    }
                }
            }
        }
        return tempList;
    }
}
