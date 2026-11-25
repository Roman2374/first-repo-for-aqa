import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Task 1
        System.out.println("\nTask 1:\n");

        Person person = new Person();

        person.firstName = "Nikolay";
        person.lastName = "Brikotkin";
        person.age = 1337;

        person.introduce();

        // Task 2
        System.out.println("\nTask 2:\n");

        List<String> fruits = new ArrayList<>();
        fruits.add("Яблоко");
        fruits.add("Апельсин");
        fruits.add("Банан");
        fruits.add("Хурма");
        fruits.add("Киви");

        for (int i = 0; i < fruits.size(); i++) {
            System.out.println(i + 1 + ". " + fruits.get(i));
        }

        // Task 3
        System.out.println("\nTask 3:\n");

        List<Double> prices = new ArrayList<>();
        prices.add(199.99);
        prices.add(299.99);
        prices.add(399.99);
        prices.add(499.99);
        prices.add(599.99);

        double budget = 1500.0;
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

        //Task 4
        System.out.println("\nTask 4:\n");

        double remainingBudget = budget;
        double countOfMoneySpent = 0;
        int countOfBuyProduct = 0;

        for (int i = 0; i < prices.size(); i++) {
            if (remainingBudget >= prices.get(i)) {
                countOfBuyProduct++;
                countOfMoneySpent += prices.get(i);
                remainingBudget -= prices.get(i);
            } else {
                break;
            }
        }

        System.out.println("Куплено: " + countOfBuyProduct + " товара на сумму " + String.format("%.2f", countOfMoneySpent));
        System.out.println("Остаток бюджета: " + String.format("%.2f", remainingBudget));
        System.out.println("Не куплено: " + (prices.size() - countOfBuyProduct) + " товара");
    }
}