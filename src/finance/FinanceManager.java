package finance;

import java.io.*;
import java.time.LocalDate;
import java.util.*;
import com.fasterxml.jackson.databind.ObjectMapper;


public class FinanceManager {
    private List<Transaction> transactions;
    private Map<String, Category> categories;

    public FinanceManager() {
        transactions = new ArrayList<>();
        categories = new HashMap<>();
        loadData();  // Load existing data on startup
    }

    // Add a new transaction
    public void addTransaction(String category, double amount, String type) {
        if (!categories.containsKey(category)) {
            System.out.println("Category not found!");
            return;
        }
        Transaction transaction = new Transaction(category, amount, LocalDate.now(), type);
        transactions.add(transaction);
        saveData();
    }

    // Add a new category
    public void addCategory(String name, double budget) {
        Category category = new Category(name, budget);
        categories.put(name, category);
        saveData();
    }

    // Generate report
    public void generateMonthlyReport() {
        // Calculate monthly expenses
        System.out.println("Monthly Report: ");
        Map<String, Double> categoryExpenses = new HashMap<>();

        for (Transaction t : transactions) {
            if (t.getDate().getMonth().equals(LocalDate.now().getMonth())) {
                categoryExpenses.put(t.getCategory(), categoryExpenses.getOrDefault(t.getCategory(), 0.0) + t.getAmount());
            }
        }

        for (String category : categoryExpenses.keySet()) {
            System.out.println("Category: " + category + ", Total Spent: " + categoryExpenses.get(category));
            System.out.println("Budget: " + categories.get(category).getBudget());
        }
    }

    // Save data to a JSON file
    public void saveData() {
        try (FileWriter writer = new FileWriter("finance_data.json")) {
            ObjectMapper mapper = new ObjectMapper();
            Map<String, Object> data = new HashMap<>();
            data.put("transactions", transactions);
            data.put("categories", categories);
            mapper.writeValue(writer, data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Load data from a JSON file
    @SuppressWarnings("unchecked")
    public void loadData() {
        try (FileReader reader = new FileReader("finance_data.json")) {
            ObjectMapper mapper = new ObjectMapper();
            Map<String, Object> data = mapper.readValue(reader, HashMap.class);
            transactions = (List<Transaction>) data.get("transactions");
            categories = (Map<String, Category>) data.get("categories");
        } catch (IOException e) {
            System.out.println("No previous data found, starting fresh.");
        }
    }
}

