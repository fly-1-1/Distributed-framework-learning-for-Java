package mapdemo1;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Map的练习
 */
public class MyMap5 {
    public static void main(String[] args) {
        HashMap<Student,String> hm = new HashMap<>();

        Student s1 = new Student("xiaohei",23);
        Student s2 = new Student("dapang",22);
        Student s3 = new Student("xiaomei",22);

        hm.put(s1,"江苏");
        hm.put(s2,"北京");
        hm.put(s3,"天津");

        //第一种：先获取到所有的键，再通过每一个键来找对应的值
        Set<Student> keys = hm.keySet();
        for (Student key : keys) {
            String value = hm.get(key);
            System.out.println(key + "----" + value);
        }

        System.out.println("===================================");

        //第二种：先获取到所有的键值对对象。再获取到里面的每一个键和每一个值
        Set<Map.Entry<Student, String>> entries = hm.entrySet();
        for (Map.Entry<Student, String> entry : entries) {
            Student key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + "----" + value);
        }
        System.out.println("===================================");
        //第三种：
        hm.forEach(
                (Student key, String value)->{
                    System.out.println(key + "----" + value);
                }
        );

    }
}
