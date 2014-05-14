package tests;

/**
 * Created by SMelnik on 4/30/2014.
 */
public class TestClass {
    public static void main(String[] args) {

        int a = 1;
        int b = 5;
        System.out.println(a & b);
        System.out.println(a | b);
        System.out.println(a ^ b);

    }

    private static int f(){
        try{
            System.out.println(0);
            return 100;
        } finally {
            System.out.println(1);
        }
    }
}