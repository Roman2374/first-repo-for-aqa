import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Double> prices = new ArrayList<>();
        prices.add(199.99);
        prices.add(299.99);
        prices.add(399.99);
        prices.add(499.99);
        prices.add(599.99);

        double budget = 1500.0;

        // Task 1
        Task_1 task1 = new Task_1();
        task1.Task_1();

        // Task 2
        Task_2 task2 = new Task_2();
        task2.Task_2();

        // Task 3
        Task_3 task3 = new Task_3();
        task3.Task_3(prices, budget);

        //Task 4
        Task_4 task4 = new Task_4();
        task4.Task_4(prices, budget);
    }
}