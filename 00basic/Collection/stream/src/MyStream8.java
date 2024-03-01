import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Stream流的收集方法
 *
 * 创建一个ArrayList集合，并添加以下字符串。字符串中前面是姓名，后面是年龄
 * "zhangsan,23"
 * "lisi,24"
 * "wangwu,25"
 * 保留年龄大于等于24岁的人，并将结果收集到Map集合中，姓名为键，年龄为值
 */
public class MyStream8 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("zhangsan,23");
        list.add("lisi,24");
        list.add("wangwu,25");

        Map<String, Integer> map = list.stream().filter(
                s -> {
                    String[] split = s.split(",");
                    int age = Integer.parseInt(split[1]);
                    return age >= 24;
                }

         //   collect方法只能获取到流中剩余的每一个数据.
         //在底层不能创建容器,也不能把数据添加到容器当中

         //Collectors.toMap 创建一个map集合并将数据添加到集合当中

          // s 依次表示流中的每一个数据

          //第一个lambda表达式就是如何获取到Map中的键
          //第二个lambda表达式就是如何获取Map中的值
        ).collect(Collectors.toMap(
                s -> s.split(",")[0],
                s -> Integer.parseInt(s.split(",")[1]) ));

        System.out.println(map);


    }
}
