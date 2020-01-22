package app;

public class App {
    public static void main(String[] args) throws Exception {
        Hello first = new Hello(3, 4);
        Hello second = new Hello(5, 6);

        first.b = first.add(first.a, second.b);
    }
}

class Hello {
    int a;
    int b;

    public Hello(int a, int b) {
        this.a = a;
        this.b = b;
    }
    public int add(int a, int b) {
        return a + b;
    }
}