module at.htlleonding.health {
    requires javafx.controls;
    requires javafx.fxml;

    opens at.htlleonding.health to javafx.fxml;
    exports at.htlleonding.health;
    exports at.htlleonding.health.controller;
    opens at.htlleonding.health.controller to javafx.fxml;
    exports at.htlleonding.observer;
    opens at.htlleonding.observer to javafx.fxml;
}
