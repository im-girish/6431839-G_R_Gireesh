package Implementing_Factory_Method_Pattern;

import java.util.Scanner;

// Product Interface
interface Notification {
    void notifyUser();
}

// Concrete Products
class SMSNotification implements Notification {
    public void notifyUser() {
        System.out.println("📩 Sending an SMS Notification");
    }
}

class EmailNotification implements Notification {
    public void notifyUser() {
        System.out.println("📧 Sending an Email Notification");
    }
}

class PushNotification implements Notification {
    public void notifyUser() {
        System.out.println("📲 Sending a Push Notification");
    }
}

// Creator (Factory)
abstract class NotificationFactory {
    public abstract Notification createNotification();
}

// Concrete Creators
class SMSNotificationFactory extends NotificationFactory {
    public Notification createNotification() {
        return new SMSNotification();
    }
}

class EmailNotificationFactory extends NotificationFactory {
    public Notification createNotification() {
        return new EmailNotification();
    }
}

class PushNotificationFactory extends NotificationFactory {
    public Notification createNotification() {
        return new PushNotification();
    }
}

// Main Class
public class FactoryMethod {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose notification type: SMS / Email / Push");
        String type = scanner.nextLine().trim();

        NotificationFactory factory;

        switch (type.toLowerCase()) {
            case "sms":
                factory = new SMSNotificationFactory();
                break;
            case "email":
                factory = new EmailNotificationFactory();
                break;
            case "push":
                factory = new PushNotificationFactory();
                break;
            default:
                System.out.println("❌ Invalid choice. Please enter SMS, Email, or Push.");
                scanner.close();
                return;
        }

        Notification notification = factory.createNotification();
        notification.notifyUser();
        scanner.close();
    }
}
