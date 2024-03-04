package ClassLoader;

public class Main {


    public static void main(String[] args) {
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();

        ClassLoader classLoader1 = systemClassLoader.getParent();

        ClassLoader classLoader2 = classLoader1.getParent();

        System.out.println(systemClassLoader);


    }

}