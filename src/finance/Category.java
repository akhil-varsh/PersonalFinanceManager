package finance;

public class Category {
    private String name;
    private double budget;

    public Category(String name, double budget) {
        this.name = name;
        this.budget = budget;
    }

    public String getName() { return name; }
    public double getBudget() { return budget; }
    
    public void setBudget(double budget) { this.budget = budget; }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                ", budget=" + budget +
                '}';
    }
}
