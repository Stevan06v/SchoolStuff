module com.example.vlajiccurrencycalculator {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.vlajiccurrencycalculator to javafx.fxml;
    exports com.example.vlajiccurrencycalculator;
}