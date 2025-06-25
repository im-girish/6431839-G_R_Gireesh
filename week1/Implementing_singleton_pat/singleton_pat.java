package Implementing_singleton_pat;

public class singleton_pat {

    private static singleton_pat i;

    private singleton_pat() {
        System.out.println("Singleton I Created");
    }

    public static singleton_pat getI() {
        if (i == null) {
            i = new singleton_pat();
        }
        return i;
    }

    public void showMessage() {
        System.out.println("Hello from Singleton");
    }

    public static void main(String[] args) {
        singleton_pat obj1 = singleton_pat.getI();
        obj1.showMessage();

        singleton_pat obj2 = singleton_pat.getI();
        obj2.showMessage();

        System.out.println("Are both objects same? " + (obj1 == obj2));
    }
}
