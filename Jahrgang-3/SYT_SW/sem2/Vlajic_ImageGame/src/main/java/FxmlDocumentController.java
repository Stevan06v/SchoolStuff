import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.FileChooser;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class FxmlDocumentController implements Initializable {

    ImageDiscoverer discoverer;
    @FXML
    public FlowPane buttonBar;
    @FXML
    public Button btnStart;
    @FXML
    public Button btnLoad;
    @FXML
    public Label labelPath;
    @FXML
    public ImageView imageView;
    @FXML
    public BorderPane borderPane;
    @FXML
    public ProgressBar progressBar;

    @FXML
    public void handleStartButton(ActionEvent actionEvent) {
        System.out.println("Start-button clicked.");

        Thread thread = new Thread(discoverer);

        thread.start();
    }

    public void handleLoadButton(ActionEvent actionEvent) {
        FileChooser fc = new FileChooser();

        fc.setTitle("Select Image");
        fc.setInitialDirectory(new File("."));
        FileChooser.ExtensionFilter efj = new FileChooser.ExtensionFilter("JPG files *.jpg", "*.jpg");
        FileChooser.ExtensionFilter efp = new FileChooser.ExtensionFilter("PNG files *.png", "*.png");

        fc.getExtensionFilters().add(efp);
        fc.getExtensionFilters().add(efj);


        File imageFile = fc.showOpenDialog(null);

        if(imageFile == null){
            return;
        }
        this.btnStart.setDisable(false);
        this.progressBar.progressProperty().bind(discoverer.progressProperty());

        labelPath.setText(imageFile.getName());

        Image img = new Image(imageFile.toURI().toString());
        setImage(img);
    }

    public void setImage(Image image){
        imageView.setImage(image);
        discoverer = new ImageDiscoverer(image);
        Image destImage = discoverer.getDestImage();
        imageView.setImage(destImage);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.btnStart.setDisable(true);
    }
}
