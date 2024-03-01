package maptest;

import java.util.TreeMap;

/**
 * 字符串“aababcabcdabcde”
 *           请统计字符串中每一个字符出现的次数，并按照以下格式输出
 *            输出结果：
 *                     a（5）b（4）c（3）d（2）e（1）
 */
public class Test2 {
    public static void main(String[] args) {
        String s = "aababcabcdabcde";

        TreeMap<Character,Integer> tm = new TreeMap<>();

        //遍历字符串，得到每一个字符
        for (int i = 0; i < s.length(); i++) {
            //c依次表示字符串中的每一个字符
            char c = s.charAt(i);
            if(!tm.containsKey(c)){
                //表示当前字符是第一次出现。
                tm.put(c,1);
            }else{
                //存在，表示当前字符已经出现过了
                //先获取这个字符已经出现的次数
                Integer count = tm.get(c);
                //自增，表示这个字符又出现了依次
                count++;
                //将自增后的结果再次添加到集合中。
                tm.put(c,count);
            }
        }
        //  a（5）b（4）c（3）d（2）e（1）
        //System.out.println(tm);
        tm.forEach(
                (Character key,Integer value)->{
                    System.out.print(key + "（" + value + "）");
                }
        );
    }
}
