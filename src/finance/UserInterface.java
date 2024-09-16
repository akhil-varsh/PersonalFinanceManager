package finance;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class UserInterface extends Application {
    private FinanceManager financeManager = new FinanceManager();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Personal Finance Manager");

        // Input fields for transaction
        TextField categoryField = new TextField();
        TextField amountField = new TextField();
        ChoiceBox<String> typeChoiceBox = new ChoiceBox<>();
        typeChoiceBox.getItems().addAll("income", "expense");
        Button addTransactionButton = new Button("Add Transaction");

        // Event handler
        addTransactionButton.setOnAction(e -> {
            String category = categoryField.getText();
            double amount = Double.parseDouble(amountField.getText());
            String type = typeChoiceBox.getValue();
            financeManager.addTransaction(category, amount, type);
        });

        // Input fields for adding a category
        TextField categoryNameField = new TextField();
        TextField categoryBudgetField = new TextField();
        Button addCategoryButton = new Button("Add Category");

        // Event handler
        addCategoryButton.setOnAction(e -> {
            String name = categoryNameField.getText();
            double budget = Double.parseDouble(categoryBudgetField.getText());
            financeManager.addCategory(name, budget);
        });

        // Layout
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setVgap(8);
        gridPane.setHgap(10);

        gridPane.add(new Label("Category:"), 0, 0);
        gridPane.add(categoryField, 1, 0);
        gridPane.add(new Label("Amount:"), 0, 1);
        gridPane.add(amountField, 1, 1);
        gridPane.add(new Label("Type:"), 0, 2);
        gridPane.add(typeChoiceBox, 1, 2);
        gridPane.add(addTransactionButton, 1, 3);

        gridPane.add(new Label("New Category Name:"), 0, 4);
        gridPane.add(categoryNameField, 1, 4);
        gridPane.add(new Label("Budget:"), 0, 5);
        gridPane.add(categoryBudgetField, 1, 5);
        gridPane.add(addCategoryButton, 1, 6);

        Scene scene = new Scene(gridPane, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

