package finance;

import java.util.HashMap;
import java.util.Map;

public class Budget {
    private Map<String, Double> categoryBudgets;

    public Budget() {
        categoryBudgets = new HashMap<>();
    }

    public void setBudget(String category, double amount) {
        categoryBudgets.put(category, amount);
    }

    public double getBudget(String category) {
        return categoryBudgets.getOrDefault(category, 0.0);
    }

    public void printBudgets() {
        for (String category : categoryBudgets.keySet()) {
            System.out.println("Category: " + category + ", Budget: " + categoryBudgets.get(category));
        }
    }
}

