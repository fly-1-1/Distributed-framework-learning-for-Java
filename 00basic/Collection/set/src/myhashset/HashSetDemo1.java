package myhashset;

import java.util.HashSet;
import java.util.Iterator;

/**
 * 添加字符串并进行遍历
 */
public class HashSetDemo1 {
    public static void main(String[] args) {
        HashSet<String> hs = new HashSet<>();

        hs.add("hello");
        hs.add("world");
        hs.add("java");
        hs.add("java");
        hs.add("java");
        hs.add("java");
        hs.add("java");
        hs.add("java");

        Iterator<String> it = hs.iterator();
        while(it.hasNext()){
            String s = it.next();
            System.out.println(s);
        }
        System.out.println("=============================");

        for (String s : hs) {
            System.out.println(s);
        }
    }
}
