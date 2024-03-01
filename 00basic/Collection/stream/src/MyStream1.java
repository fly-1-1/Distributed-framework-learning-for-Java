import java.util.ArrayList;
import java.util.List;

/**
 * 体验Stream流
 * <p>
 * 创建一个集合，存储多个字符串元素
 * "张三丰","张无忌","张翠山","王二麻子","张良","谢广坤"
 * <p>
 * 把集合中所有以"张"开头的元素存储到一个新的集合
 * <p>
 * <p>
 * 把"张"开头的集合中的长度为3的元素存储到一个新的集合
 * 遍历上一步得到的集合
 */
public class MyStream1 {
    public static void main(String[] args) {
        //集合的批量添加
        ArrayList<String> list1 = new ArrayList<>(List.of("张三丰", "张无忌", "张翠山", "王二麻子", "张良", "谢广坤"));
        //list.add()

        list1.stream().filter(s -> s.startsWith("张")).filter(s -> s.length() == 3).forEach(s -> {
            System.out.print(s + " ");
        });

        //遍历list1把以张开头的元素添加到list2中。
//        ArrayList<String> list2 = new ArrayList<>();
//        for (String s : list1) {
//            if(s.startsWith("张")){
//                list2.add(s);
//            }
//        }
//
//        //遍历list2集合，把其中长度为3的元素，再添加到list3中。
//        ArrayList<String> list3 = new ArrayList<>();
//        for (String s : list2) {
//            if(s.length() == 3){
//                list3.add(s);
//            }
//        }
//        for (String s : list3) {
//            System.out.println(s);
//        }
//
//        System.out.println("=======================");
//       //Stream流
//        list1.stream().filter(s->s.startsWith("张"))
//                .filter(s->s.length() == 3)
//                .forEach(s-> System.out.println(s));
//    }
    }
}
