package treesettest;

import java.util.TreeSet;

/**
 * 键盘录入3个学生信息，属性为(姓名,语文成绩,数学成绩,英语成绩),按照总分从低到高输出到控制台
 */

public class TreeSetTest {
    public static void main(String[] args) {
        TreeSet<Student>  ts = new TreeSet<>();

        Student s1 = new Student("dahei",80,80,80);
        Student s2 = new Student("erhei",90,90,90);
        Student s3 = new Student("xiaohei",100,100,100);

        ts.add(s1);
        ts.add(s2);
        ts.add(s3);


        for (Student student : ts) {
            System.out.println(student);
        }
    }
}
