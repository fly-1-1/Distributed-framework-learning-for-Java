package mapdemo1;

import java.util.HashMap;
import java.util.Map;

/**
 * Map的基本使用
 */
public class MyMap1 {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();

        //map.add();
        map.put("itheima001","小智");
        map.put("itheima002","小美");
        map.put("itheima003","大胖");

        System.out.println(map);
    }
}
