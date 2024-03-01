package mapdemo1;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Map的第二种遍历方式
 */
public class MyMap4 {
    public static void main(String[] args) {
        //创建集合并添加元素
        Map<String,String> map = new HashMap<>();
        map.put("1号丈夫","1号妻子");
        map.put("2号丈夫","2号妻子");
        map.put("3号丈夫","3号妻子");
        map.put("4号丈夫","4号妻子");
        map.put("5号丈夫","5号妻子");

        //首先要获取到所有的键值对对象。
        //Set集合中装的是键值对对象（Entry对象）
        //而Entry里面装的是键和值
        Set<Map.Entry<String, String>> entries = map.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            //得到每一个键值对对象
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + "---" + value);
        }
    }
}
