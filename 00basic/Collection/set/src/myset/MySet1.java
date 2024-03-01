package myset;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Set集合的基本使用
 */
public class  MySet1 {
    public static void main(String[] args) {
        Set<String> set = new TreeSet<>();
        set.add("ccc");
        set.add("aaa");
        set.add("aaa");
        set.add("bbb");

//        for (int i = 0; i < set.size(); i++) {
//            //Set集合是没有索引的，所以不能使用通过索引获取元素的方法
//        }
        Iterator<String> it = set.iterator();
        while (it.hasNext()){
            String s = it.next();
            System.out.println(s);
        }
        System.out.println("-----------------------------------");

        for (String s : set) {
            System.out.println(s);
        }
    }
}
