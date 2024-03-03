package myvolatile2;

public class Money {
    public static Object lock = new Object();
    public static volatile int money = 100000;
}
