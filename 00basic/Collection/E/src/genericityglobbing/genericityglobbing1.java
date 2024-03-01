package genericityglobbing;

import java.util.ArrayList;

/**
 * 类型通配符：<?>
 *      ArrayList<?>：表示元素类型未知的ArrayList，它的元素可以匹配任何的类型
 *      但是并不能把元素添加到ArrayListList中了，获取出来的也是Object类型
 *
 * 类型通配符上限：<? extends 类型>
 *      ArrayList<? extends Number>：它表示的类型是Number或者其子类型
 *
 * 类型通配符下限：<? super 类型>
 *      ArrayList<? super Number>：它表示的类型是Number或者其父类型
 */

public class genericityglobbing1 {
    public static void main(String[] args) {

    }
}

