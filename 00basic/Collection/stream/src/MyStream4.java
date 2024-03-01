import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * Stream流的中间方法
 */
public class MyStream4 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("张三丰");
        list.add("张无忌");
        list.add("张翠山");
        list.add("王二麻子");
        list.add("张良");
        list.add("谢广坤");
        list.add("谢广坤");
        list.add("谢广坤");
        list.add("谢广坤");
        list.add("谢广坤");


        //method1(list);
        //method2(list);
        //method3();
        //method4(list);


    }

    private static void method4(ArrayList<String> list) {
        //        Stream<T> distinct​()：去除流中重复的元素。依赖(hashCode和equals方法)
        list.stream().distinct().forEach(s-> System.out.println(s));
    }

    private static void method3() {
        //static <T> Stream<T> concat​(Stream a, Stream b)：合并a和b两个流为一个流
        ArrayList<String> list = new ArrayList<>();
        list.add("张三丰");
        list.add("张无忌");
        list.add("张翠山");
        list.add("王二麻子");
        list.add("张良");
        list.add("谢广坤");
        list.add("谢广坤");
        list.add("谢广坤");
        list.add("谢广坤");
        list.add("谢广坤");

        ArrayList<String> list2 = new ArrayList<>();
        list2.add("张三丰");
        list2.add("张无忌");
        list2.add("张翠山");
        list2.add("王二麻子");
        list2.add("张良");
        list2.add("谢广坤");


//        Stream<String> stream1 = list.stream();
//        Stream<String> stream2 = list2.stream();
//
//        Stream<String> stream3 = Stream.concat(stream1, stream2);
//        stream3.forEach(s-> System.out.println(s));

        Stream.concat(list.stream(),list2.stream()).forEach(s-> System.out.println(s));
    }

    private static void method2(ArrayList<String> list) {
        //        Stream<T> skip​(long n)：跳过指定参数个数的数据
        list.stream().skip(2).forEach(s-> System.out.println(s));
    }

    private static void method1(ArrayList<String> list) {
        //        Stream<T> limit​(long maxSize)：截取指定参数个数的数据
        list.stream().limit(2).forEach(s-> System.out.println(s));
    }
}
