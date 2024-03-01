package genericitymethod;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 使用Java中的泛型方法
 */

public class GenericityMethod1 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("给小花同学的土味情话");
        list.add("给小丽同学的土味情话");
        list.add("给小路同学的土味情话");
        //将list集合转成一个数组并返回
        //如果是空参的,那么返回的数组类型为Object类型的.
        Object[] objects = list.toArray();
        System.out.println(Arrays.toString(objects));

        String[] strings = list.toArray(new String[list.size()]);
        System.out.println(Arrays.toString(strings));

    }
}
