import java.util.Scanner;

interface Notification {
    void notifyUser(String message);
}

class EmailNotification implements Notification {
    @Override
    public void notifyUser(String message) {
        System.out.println("Sending Email Notification: " + message);
    }
}

class SMSNotification implements Notification {
    @Override
    public void notifyUser(String message) {
        System.out.println("Sending SMS Notification: " + message);
    }
}

class PushNotification implements Notification {
    @Override
    public void notifyUser(String message) {
        System.out.println("Sending Push Notification: " + message);
    }
}

class NotificationFactory {
    public Notification createNotification(String type) {
        if (type == null || type.isEmpty())
            return null;

        switch (type.toUpperCase()) {
            case "EMAIL":
                return new EmailNotification();
            case "SMS":
                return new SMSNotification();
            case "PUSH":
                return new PushNotification();
            default:
                return null;
        }
    }
}

public class FactoryMethodAdvancedDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        NotificationFactory factory = new NotificationFactory();

        System.out.println("Welcome to E-Commerce Notification System");
        System.out.println("Choose Notification Type: EMAIL, SMS, PUSH");
        String type = scanner.nextLine();

        Notification notification = factory.createNotification(type);

        if (notification != null) {
            System.out.println("Enter the message to send:");
            String message = scanner.nextLine();
            notification.notifyUser(message);
        } else {
            System.out.println("Invalid Notification Type.");
        }

        scanner.close();
    }
}
