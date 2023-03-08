package com.example.vlajiccurrencycalculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class HelloController {
    @FXML
    private ComboBox currencies;
    @FXML
    private TextField convertedValue;
    @FXML
    private TextField currentValue;
    @FXML
    private Canvas canvasBox;
    private GraphicsContext gc;
    private HashMap<String, List<Double>> currencyHashMap;
    public HelloController() {}

    private List<Double> getFileData(String currency_path) {

        Path path = null;
        try {
            path = Paths.get(this.getClass().getResource(currency_path).toURI());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        try {
            List<String> lines = Files.readAllLines(path);
            List<Double> converted_currencies = new LinkedList<>();
            // convert string-values to doubles
            for (String iterator : lines) {
                converted_currencies.add(Double.parseDouble(iterator));
            }
            return converted_currencies;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void initialize(){
        currencyHashMap = new HashMap<>();
        currencies.getItems().add("PLN");
        currencies.getItems().add("JPY");
        currencies.getItems().add("USD");
        convertedValue.setEditable(false);
        canvasBox.setHeight(300);
        canvasBox.setWidth(300);
        gc = canvasBox.getGraphicsContext2D();
    }
    @FXML
    private void sendValue(ActionEvent actionEvent) {
        try {
            // get value out of input field
            double currentValue = Double.parseDouble(this.currentValue.getText());

            try {
                String selectedItem = this.currencies.getSelectionModel().getSelectedItem().toString();
                // load currencies from file into list
                List<Double> currencies = this.currencyHashMap.get(selectedItem);

                // load the last multiplier
                double lastCurrencyMultiplier = currencies.get(currencies.size() - 1);
                double convertedValue = lastCurrencyMultiplier * currentValue;

                this.convertedValue.setText(String.format("%.2f", convertedValue));

            } catch (Exception err) {
                System.out.println("Error while loading cvs!");
            }
        }catch(Exception err){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR Dialog");
            alert.setContentText("Input values or currency selection missing!");
            alert.showAndWait();
        }
    }
    @FXML
    private void resetValue(ActionEvent actionEvent) {
        try{
            this.currentValue.setText("");
            this.convertedValue.setText("");
            // clear selection
            this.currencies.getSelectionModel().clearSelection();
            this.canvasBox.getGraphicsContext2D().fill();
        }catch (Exception err){

        }
    }

    public void changeCurrency(ActionEvent actionEvent) {

        String selectedItem = this.currencies.getSelectionModel().getSelectedItem().toString();
        // build file-dest string
        String filename = "data/" + selectedItem.toLowerCase() + ".txt";

        if(!this.currencyHashMap.containsKey(selectedItem)){
            this.currencyHashMap.put(selectedItem, this.getFileData(filename));
        }


        gc.clearRect(0, 0, canvasBox.getWidth(), canvasBox.getHeight());
        System.out.println("currency changed");

        System.out.println(canvasBox.getHeight());
        gc.setStroke(Color.BLUE);

        String selection = this.currencies.getSelectionModel().getSelectedItem().toString();


        List<Double> values = this.getFileData(filename);

        gc.setFill(Color.DARKRED);

        double xMin = 0;
        double xMax = values.size() - 1;
        double yMin = 126;
        double yMax = 133;

        // set x-axis and y-axis scales
        double xScale = canvasBox.getWidth() / (xMax - xMin);
        double yScale = canvasBox.getHeight() / (yMax - yMin);

        // draw x-axis
        gc.setStroke(Color.BLACK);
        gc.strokeLine(0, canvasBox.getHeight() - (yMax - yMin) * yScale, canvasBox.getWidth(), canvasBox.getHeight() - (yMax - yMin) * yScale);

        // draw y-axis
        gc.strokeLine(0, 0, 0, canvasBox.getHeight());

        // plot data points
        gc.setStroke(Color.RED);
        for (int i = 0; i < values.size()-1; i++) {
            double x1 = i * xScale;
            double y1 = canvasBox.getHeight() - (values.get(i) - yMin) * yScale;
            double x2 = (i + 1) * xScale;
            double y2 = canvasBox.getHeight() - (values.get(i+1) - yMin) * yScale;
            gc.strokeLine(x1, y1, x2, y2);
        }
    }
}