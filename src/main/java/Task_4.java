import java.util.List;

public class Task_4 {
    void Task_4(List<Double> prices, double budget) {
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
