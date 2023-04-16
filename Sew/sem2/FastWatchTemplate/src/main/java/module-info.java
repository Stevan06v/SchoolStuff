module at.htlleonding.watch {
    requires javafx.controls;
    requires javafx.fxml;

    opens at.htlleonding.watch to javafx.fxml;
    exports at.htlleonding.watch;
    exports at.htlleonding.watch.model;
    opens at.htlleonding.watch.model to javafx.fxml;
    exports at.htlleonding.watch.controller;
    opens at.htlleonding.watch.controller to javafx.fxml;
}
