package Financial_Forecasting;

import java.util.*;

class FinancialForecasting {

    private Queue<Double> priceWindow;
    private int windowSize;
    private List<Double> priceHistory;

    public FinancialForecasting(int windowSize) {
        this.windowSize = windowSize;
        priceWindow = new LinkedList<>();
        priceHistory = new ArrayList<>();
    }

    public void addPrice(double price) {
        priceHistory.add(price);

        if (priceWindow.size() == windowSize) {
            priceWindow.poll();
        }
        priceWindow.offer(price);
    }

    public double getForecast() {
        if (priceWindow.isEmpty()) {
            throw new IllegalStateException("No prices available for forecasting!");
        }

        double sum = 0.0;
        for (double price : priceWindow) {
            sum += price;
        }
        return sum / priceWindow.size();
    }

    public void displayPriceHistory() {
        System.out.println("Complete Price History: " + priceHistory);
    }

    public void displayCurrentWindow() {
        System.out.println("Current Sliding Window: " + priceWindow);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Moving Average Window Size: ");
        int windowSize = sc.nextInt();

        FinancialForecasting forecast = new FinancialForecasting(windowSize);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add New Price");
            System.out.println("2. Get Forecast (Moving Average)");
            System.out.println("3. Show Price History");
            System.out.println("4. Show Current Window");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter new price: ");
                    double price = sc.nextDouble();
                    forecast.addPrice(price);
                    break;
                case 2:
                    try {
                        System.out.println("Forecasted Price (Moving Average): " + forecast.getForecast());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    forecast.displayPriceHistory();
                    break;
                case 4:
                    forecast.displayCurrentWindow();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
