package finance;
import java.time.LocalDate;

public class Transaction {
    private String category;
    private double amount;
    private LocalDate date;
    private String type;  // "income" or "expense"

    public Transaction(String category, double amount, LocalDate date, String type) {
        this.category = category;
        this.amount = amount;
        this.date = date;
        this.type = type;
    }

    public String getCategory() { return category; }
    public double getAmount() { return amount; }
    public LocalDate getDate() { return date; }
    public String getType() { return type; }

    @Override
    public String toString() {
        return "Transaction{" +
                "category='" + category + '\'' +
                ", amount=" + amount +
                ", date=" + date +
                ", type='" + type + '\'' +
                '}';
    }
}
