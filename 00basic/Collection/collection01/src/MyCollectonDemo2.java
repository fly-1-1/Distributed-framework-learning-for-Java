import java.util.ArrayList;
import java.util.Collection;

public class MyCollectonDemo2 {
    public static void main(String[] args) {
        Collection<String> collection = new ArrayList<>();
//        boolean add(E e)		添加元素
        collection.add("aaa");
        collection.add("bbb");
        collection.add("ccc");
        collection.add("dddd");
        /*System.out.println(collection);*/
        //method1(collection);
        //method2(collection);
        //method3(collection);
        //method4(collection);
        //method5(collection);
        //method6(collection);


    }

    private static void method6(Collection<String> collection) {
        //        int size()			集合的长度，也就是集合中元素的个数
        int size = collection.size();
        System.out.println(size);
    }

    private static void method5(Collection<String> collection) {
        //        boolean isEmpty()		判断集合是否为空
        collection.clear();
        boolean result = collection.isEmpty();
        System.out.println(result);
    }

    private static void method4(Collection<String> collection) {
        //        boolean contains(Object o)	判断集合中是否存在指定的元素
        boolean result = collection.contains("a");
        System.out.println(result);


        boolean result2 = collection.contains("aaa");
        System.out.println(result2);
    }

    private static void method3(Collection<String> collection) {
        //        void clear()			清空集合
        //就是将集合中所有的元素全部删除.
        collection.clear();
        System.out.println(collection);
    }

    private static void method2(Collection<String> collection) {
        //        boolean removeif(Object o)	根据条件进行删除
        //removeif底层会遍历集合,得到集合中的每一个元素
        //s依次表示集合中的每一个元素
        //就会把这每一个元素都到lambda表达式中去判断一下
        //如果返回的是true,则删除
        //如果返回的是false,则保留不删除.


        //boolean test(String t);
        collection.removeIf(
                (String s)->{
                    return s.length() == 3;
                }

        );
        System.out.println(collection);
    }

    private static void method1(Collection<String> collection) {
        //        boolean remove(Object o)	    从集合中移除指定的元素
        //如果删除成功了,则返回true
        //如果删除失败了,则返回false
        boolean result1 = collection.remove("aaa");
        boolean result2 = collection.remove("ddd");
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(collection);
    }
}
