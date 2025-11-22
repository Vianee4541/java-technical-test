public class App {
    public static void main(String[] args) {
        int a = 5;
        int b = 3;

        a = a + b; // 8
        b = a - b; // 5
        a = a - b; // 3

        System.out.println("a = " + a + ", b = " + b);
    }
}
