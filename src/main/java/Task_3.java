import java.util.List;

public class Task_3 {
    void Task_3(List<Double> prices, double budget) {
        System.out.println("\nTask 3:\n");

        double totalPrice = 0.0;

        for (double price : prices) {
            totalPrice += price;
        }

        if (totalPrice <= budget) {
            System.out.println("Бюджета хватает!");
            double remainingBudget = budget - totalPrice;
            System.out.println("Остаток: " + String.format("%.2f", remainingBudget));
        } else {
            System.out.println("Бюджета не хватает! Не хватает: " + String.format("%.2f", totalPrice - budget));
        }
    }
}
