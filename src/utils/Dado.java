package utils;

public class Dado {
    public static int rolarDado(int numeroDeFaces) {
        return (int) (Math.random() * numeroDeFaces) + 1;
    }
}
