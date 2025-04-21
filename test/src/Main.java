public class Main {
    public static class User {
        User(int i) {
            System.out.println("1111111111111");
        }

        ;

        void out() {
            System.out.println("22222222222222222222");
        }
    }

    public static void main(String[] args) {

        System.out.println("Hello, World!");
        User user = new User(1);
        user.out();
    }
}