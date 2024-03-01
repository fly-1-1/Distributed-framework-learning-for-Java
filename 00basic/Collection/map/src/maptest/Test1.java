package maptest;

import java.util.Comparator;
import java.util.TreeMap;

/**
 * 需求：创建一个TreeMap集合，键是学生对象(Student)，值是籍贯(String)。
 *           学生属性姓名和年龄，按照年龄进行排序并遍历。
 */
public class Test1 {
    public static void main(String[] args) {
        TreeMap<Student,String> tm = new TreeMap<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                int result = o1.getAge() - o2.getAge();
                result = result== 0 ? o1.getName().compareTo(o2.getName()) : result;
                return result;
            }
        });

        Student s1 = new Student("xiaohei",23);
        Student s2 = new Student("dapang",22);
        Student s3 = new Student("xiaomei",22);

        tm.put(s1,"江苏");
        tm.put(s2,"北京");
        tm.put(s3,"天津");

        tm.forEach(
                (Student key, String value)->{
                    System.out.println(key + "---" + value);
                }
        );
    }
}
