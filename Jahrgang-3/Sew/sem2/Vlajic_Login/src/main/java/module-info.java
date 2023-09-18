module com.example.vlajic_login {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.vlajic_login to javafx.fxml;
    exports com.example.vlajic_login;
}