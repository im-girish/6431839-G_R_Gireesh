import java.util.Scanner;

// Product Interface
interface ProductSearch {
    void search(String query);
}

// Concrete Product - BookSearch
class BookSearch implements ProductSearch {
    @Override
    public void search(String query) {
        System.out.println("Searching Books for: " + query);
        System.out.println("Results: 'Effective Java', 'Clean Code', 'Java Concurrency in Practice'");
    }
}

// Concrete Product - ElectronicsSearch
class ElectronicsSearch implements ProductSearch {
    @Override
    public void search(String query) {
        System.out.println("Searching Electronics for: " + query);
        System.out.println("Results: 'Dell Laptop', 'Samsung Galaxy S21', 'Sony Headphones'");
    }
}

// Concrete Product - ClothingSearch
class ClothingSearch implements ProductSearch {
    @Override
    public void search(String query) {
        System.out.println("Searching Clothing for: " + query);
        System.out.println("Results: 'Levi’s Jeans', 'Nike T-Shirt', 'Adidas Shoes'");
    }
}

// Factory Class
class SearchFactory {
    public ProductSearch getSearch(String type) {
        if (type == null)
            return null;
        if (type.equalsIgnoreCase("BOOK")) {
            return new BookSearch();
        } else if (type.equalsIgnoreCase("ELECTRONICS")) {
            return new ElectronicsSearch();
        } else if (type.equalsIgnoreCase("CLOTHING")) {
            return new ClothingSearch();
        }
        return null;
    }
}

// Client Code
public class Ecommerce_search {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SearchFactory factory = new SearchFactory();

        System.out.println("Welcome to E-Commerce Search!");
        System.out.print("Enter product type to search (Book, Electronics, Clothing): ");
        String type = scanner.nextLine();

        System.out.print("Enter your search query: ");
        String query = scanner.nextLine();

        ProductSearch search = factory.getSearch(type);

        if (search != null) {
            search.search(query);
        } else {
            System.out.println("❌ Invalid product type entered.");
        }

        scanner.close();
    }
}
