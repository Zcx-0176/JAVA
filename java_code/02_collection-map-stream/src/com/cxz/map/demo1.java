package com.cxz.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class demo1 {
    public static void main(String[] args) {
        // 创建集合对象
        Map<String,String> map = new HashMap<String,String>();
        // 添加元素
        map.put("张三","23");
        map.put("李四","24");
        map.put("王五","25");
        map.put("赵六","26");
        map.put("小七","27");
        map.put(null,null);
        System.out.println(map);
        System.out.println(map.get("张三"));
        map.remove("张三");
        System.out.println(map);
        System.out.println(map.containsKey("张三"));
        System.out.println(map.containsValue("23"));
        System.out.println(map.size());
        System.out.println(map.isEmpty());
        map.clear();
        System.out.println(map);
        map.put("张三","23");
        map.put("李四","24");
        map.put("王五","25");
        map.put("赵六","26");
        map.put("小七","27");
        Set< String > keys = map.keySet();
        for (String key : keys) {
            System.out.println(key+"--"+map.get(key));
        }
        Collection< String > values = map.values();
        for (String value : values) {
            System.out.println(value);
        }
        Set< Map.Entry< String, String >> entrySet = map.entrySet();
        for (Map.Entry< String, String > entry : entrySet) {
            System.out.println(entry.getKey()+"--"+entry.getValue());
        }
    }
}
