module at.htlleonding.demo.addressbook {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens at.htlleonding.demo.addressbook to javafx.fxml;
    exports at.htlleonding.demo.addressbook;
    exports at.htlleonding.demo.addressbook.controller;
    opens at.htlleonding.demo.addressbook.controller to javafx.fxml;
}