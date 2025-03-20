import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the store! Please choose language: ");
        System.out.println("1. Finnish");
        System.out.println("2. Swedish");
        System.out.println("3. English");
        System.out.println("4. Japanese");

        Scanner sc = new Scanner(System.in);
        int language = sc.nextInt();
        Locale locale;
        switch (language) {
            case 1:
                locale = new Locale("fi", "FI");
                break;
            case 2:
                locale = new Locale("sv", "SE");
                break;
            case 3:
                locale = new Locale("en", "US");
                break;
            case 4:
                locale = new Locale("ja", "JP");
                break;
            default:
                System.out.println("Invalid choice. Defaulting to English");
                locale = new Locale("en", "US");
                break;
        }
        ResourceBundle rb;
        try {
            rb = ResourceBundle.getBundle("messages", locale);
        } catch (Exception e) {
            System.out.println("resource bundle not found");
            rb = ResourceBundle.getBundle("messages", new Locale("en", "US"));
        }

        System.out.println(rb.getString("amount"));
        double amount = sc.nextDouble();
        System.out.println(rb.getString("price"));
        double price = sc.nextDouble();
        System.out.println(rb.getString("quantity"));
        double quantity = sc.nextDouble();

        double itemCost = getItemCost(price, quantity);
        System.out.println("Item cost: " + itemCost);
        double totalCost = getTotalCost(amount, itemCost);
        System.out.println(rb.getString("totalCost") + totalCost);
    }

    public static double getItemCost(double price, double quantity) {
        return price * quantity;
    }

    public static double getTotalCost(double amount, double itemCost) {
        return amount * itemCost;
    }
}