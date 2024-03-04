package ClassLoader;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ClassLoaderDemo2 {
    public static void main(String[] args) throws IOException {
        //static ClassLoader getSystemClassLoader() 获取系统类加载器
        //InputStream getResourceAsStream(String name)  加载某一个资源文件

        //获取系统类加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();

        //利用加载器去加载一个指定的文件
        //参数：文件的路径
        //返回值：字节流。
        InputStream is = systemClassLoader.getResourceAsStream("ClassLoader/prop.properties");

        Properties prop = new Properties();
        prop.load(is);

        System.out.println(prop);

        is.close();
    }
}
