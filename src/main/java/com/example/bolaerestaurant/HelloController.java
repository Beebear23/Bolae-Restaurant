package com.example.bolaerestaurant;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class HelloController {

    // Breakfast
    @FXML private CheckBox eggsBox;
    @FXML private CheckBox toastBox;
    @FXML private CheckBox pancakesBox;

    // Lunch
    @FXML private CheckBox sandwichBox;
    @FXML private CheckBox saladBox;
    @FXML private CheckBox pizzaBox;

    // Dinner
    @FXML private CheckBox steakBox;
    @FXML private CheckBox chickenBox;
    @FXML private CheckBox burgerBox;

    // Dessert
    @FXML private RadioButton cakeRadio;
    @FXML private RadioButton icecreamRadio;

    // Fields
    @FXML private TextField totalField;
    @FXML private TextField cashField;
    @FXML private TextField changeField;
    @FXML private Label timeLabel;

    double drinkPrice = 0;

    Model model = new Model();

    @FXML
    public void initialize(){

        eggsBox.setOnAction(e -> updateTotal());
        toastBox.setOnAction(e -> updateTotal());
        pancakesBox.setOnAction(e -> updateTotal());

        sandwichBox.setOnAction(e -> updateTotal());
        saladBox.setOnAction(e -> updateTotal());
        pizzaBox.setOnAction(e -> updateTotal());

        steakBox.setOnAction(e -> updateTotal());
        chickenBox.setOnAction(e -> updateTotal());
        burgerBox.setOnAction(e -> updateTotal());

        cakeRadio.setOnAction(e -> updateTotal());
        icecreamRadio.setOnAction(e -> updateTotal());
    }

    private void updateTotal(){

        double total = 0;

        if(eggsBox.isSelected()) total += model.eggs;
        if(toastBox.isSelected()) total += model.toast;
        if(pancakesBox.isSelected()) total += model.pancakes;

        if(sandwichBox.isSelected()) total += model.sandwich;
        if(saladBox.isSelected()) total += model.salad;
        if(pizzaBox.isSelected()) total += model.pizza;

        if(steakBox.isSelected()) total += model.steak;
        if(chickenBox.isSelected()) total += model.chicken;
        if(burgerBox.isSelected()) total += model.burger;

        if(cakeRadio.isSelected()) total += model.cake;
        if(icecreamRadio.isSelected()) total += model.icecream;

        total += drinkPrice;

        totalField.setText(String.format("%.2f", total));
    }

    @FXML
    private void selectCoke(){
        drinkPrice = model.coke;
        updateTotal();
    }

    @FXML
    private void selectJuice(){
        drinkPrice = model.juice;
        updateTotal();
    }

    @FXML
    private void selectCoffee(){
        drinkPrice = model.coffee;
        updateTotal();
    }

    @FXML
    private void calculateChange(){

        try{

            double total = Double.parseDouble(totalField.getText());
            double cash = Double.parseDouble(cashField.getText());

            double change = cash - total;

            changeField.setText(String.format("%.2f", change));

            LocalDateTime time = LocalDateTime.now();
            DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm:ss");

            timeLabel.setText("Time: " + time.format(format));

        }catch(Exception e){
            changeField.setText("Enter Cash");
        }
    }

    @FXML
    private void saveOrder(){

        try{

            FileWriter writer = new FileWriter("orders.txt", true);

            writer.write("Bolae Restaurant\n");
            writer.write("Total: " + totalField.getText() + "\n");
            writer.write("Cash Paid: " + cashField.getText() + "\n");
            writer.write("Change: " + changeField.getText() + "\n");
            writer.write("Time: " + timeLabel.getText() + "\n");
            writer.write("----------------------------\n");

            writer.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    private void resetOrder(){

        eggsBox.setSelected(false);
        toastBox.setSelected(false);
        pancakesBox.setSelected(false);

        sandwichBox.setSelected(false);
        saladBox.setSelected(false);
        pizzaBox.setSelected(false);

        steakBox.setSelected(false);
        chickenBox.setSelected(false);
        burgerBox.setSelected(false);

        cakeRadio.setSelected(false);
        icecreamRadio.setSelected(false);

        totalField.clear();
        cashField.clear();
        changeField.clear();
        timeLabel.setText("");

        drinkPrice = 0;
    }

    @FXML
    private void exitSystem(){
        System.exit(0);
    }
}