import java.util.ArrayList;
import java.util.List;

public class Task_2 {
    void Task_2() {
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
    }
}
