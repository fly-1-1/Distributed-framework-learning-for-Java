import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyListDemo1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");




        Iterator<String> it = list.iterator();
        while(it.hasNext()){
            String s = it.next();
            System.out.println(s);
        }

        System.out.println("---------------------");
        for (String s : list) {
            System.out.println(s);
        }
    }
}
