package mapdemo1;

import java.util.HashMap;
import java.util.Map;
/**
 * Map的基本方法
 */
public class MyMap2 {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("itheima001","小智");
        map.put("itheima002","小美");
        map.put("itheima003","大胖");
        map.put("itheima004","小黑");
        map.put("itheima005","大师");

        //method1(map);
        //method2(map);
        //method3(map);
        //method4(map);
        //method5(map);
        //method6(map);
        //method7(map);

    }

    private static void method7(Map<String, String> map) {
        //        int size()              集合的长度，也就是集合中键值对的个数
        int size = map.size();
        System.out.println(size);
    }

    private static void method6(Map<String, String> map) {
        //        boolean isEmpty()       判断集合是否为空
        boolean empty1 = map.isEmpty();
        System.out.println(empty1);//false

        map.clear();
        boolean empty2 = map.isEmpty();
        System.out.println(empty2);//true
    }

    private static void method5(Map<String, String> map) {
        //        boolean containsValue(Object value) 判断集合是否包含指定的值
        boolean result1 = map.containsValue("aaa");
        boolean result2 = map.containsValue("小智");
        System.out.println(result1);
        System.out.println(result2);
    }

    private static void method4(Map<String, String> map) {
        //        boolean containsKey(Object key) 判断集合是否包含指定的键
        boolean result1 = map.containsKey("itheima001");
        boolean result2 = map.containsKey("itheima006");
        System.out.println(result1);
        System.out.println(result2);
    }

    private static void method3(Map<String, String> map) {
        //        void clear()            移除所有的键值对元素
        map.clear();
        System.out.println(map);
    }

    private static void method2(Map<String, String> map) {
        //        V remove(Object key)    根据键删除键值对元素
        String s = map.remove("itheima001");
        System.out.println(s);
        System.out.println(map);
    }

    private static void method1(Map<String, String> map) {
        //        V put(K key,V value)    添加元素
        //如果要添加的键不存在，那么会把键值对都添加到集合中
        //如果要添加的键是存在的，那么会覆盖原先的值，把原先值当做返回值进行返回。
        String s = map.put("itheima001", "aaa");
        System.out.println(s);
        System.out.println(map);
    }
}
