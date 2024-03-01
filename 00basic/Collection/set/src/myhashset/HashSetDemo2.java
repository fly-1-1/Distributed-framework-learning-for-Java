package myhashset;

/**
 * 计算哈希值
 */
public class HashSetDemo2 {
    public static void main(String[] args) {
        Student s1 = new Student("xiaozhi",23);
        Student s2 = new Student("xiaomei",22);

        //因为在Object类中，是根据对象的地址值计算出来的哈希值。
        System.out.println(s1.hashCode());//1060830840
        System.out.println(s1.hashCode());//1060830840


        System.out.println(s2.hashCode());//2137211482
    }
}
