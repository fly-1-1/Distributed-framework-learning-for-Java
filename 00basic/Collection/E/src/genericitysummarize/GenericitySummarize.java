package genericitysummarize;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *  不写泛型的弊端
 */
public class GenericitySummarize {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        list.add(123);

        Iterator it = list.iterator();
        while(it.hasNext()){
            String next = (String) it.next();
            int len = next.length();
            System.out.println(len);

        }
    }
}
