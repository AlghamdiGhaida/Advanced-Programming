package project;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Payment {
    //Buttons

    Button payButton = new Button("Pay");
    //Label for message 1
    Label msg1 = new Label("");
    //TextFiles for payment
    TextField pm1 = new TextField();
    TextField pm2 = new TextField();
    TextField pm3 = new TextField();
    TextField pm4 = new TextField();
    PasswordField t5 = new PasswordField();

    public Payment() {

    }//Defult constructor
    //Boolean metood for valation payment

    public boolean valdatePayment() {
        msg1.setTextFill(Color.RED);
        if (pm1.getText().isEmpty()) {
            msg1.setText("Enter Name Card: ");
            return false;
        } else if (pm2.getText().isEmpty()) {
            msg1.setVisible(true);
            msg1.setText("Enter Card Number");
            return false;
        } else if (pm2.getText().length() != 16) {
            msg1.setVisible(true);
            msg1.setText("The Card Number Should Have Length 16");
            return false;
        } else if (!pm2.getText().matches("[0-9]+")) {
            msg1.setVisible(true);
            msg1.setText("Number MUST Be Digit Only ");
            return false;
        } else if (pm3.getText().isEmpty()) {
            msg1.setVisible(true);
            msg1.setText("Enter Expiry Date");
            return false;
        } else if (pm4.getText().isEmpty()) {
            msg1.setVisible(true);
            msg1.setText("Enter CVV");
            return false;
        } else if (pm4.getText().length() != 3) {
            msg1.setVisible(true);
            msg1.setText("The CVV Number Should Have Length 3");
            return false;
        } else if (!pm4.getText().matches("[0-9]+")) {
            msg1.setVisible(true);
            msg1.setText("Number MUST Be Digit Only ");
            return false;
        }
        return true;
    }

    public BorderPane pay() {
        //Lables for payment
        Label p1 = new Label("Card Name: ");
        Label p2 = new Label("Card Number: ");
        Label p3 = new Label("Expiry Date: ");
        Label p4 = new Label("CVV ");
        //GridePane for Patment
        GridPane GridPayment = new GridPane();
        GridPayment.setPadding(new Insets(20, 20, 20, 20));
        GridPayment.add(p1, 0, 0);
        GridPayment.add(pm1, 1, 0);
        GridPayment.add(p2, 0, 1);
        GridPayment.add(pm2, 1, 1);
        GridPayment.add(p3, 0, 2);
        GridPayment.add(pm3, 1, 2);
        GridPayment.add(p4, 0, 3);
        GridPayment.add(pm4, 1, 3);
        GridPayment.setHgap(10);
        GridPayment.setVgap(10);
        //HBox for button
        HBox hboxForButton = new HBox();
        hboxForButton.setSpacing(30);
        hboxForButton.setPadding(new Insets(40, 60, 60, 60));
        hboxForButton.getChildren().addAll(msg1, payButton);
        hboxForButton.setAlignment(Pos.BOTTOM_CENTER);
        //Root BorderPane
        BorderPane root = new BorderPane();
        root.setCenter(GridPayment);
        root.setBottom(hboxForButton);

        //Styling
        root.setStyle("-fx-background-color: rgb(112, 160, 175)");
        pm1.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);");
        pm2.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);");
        pm3.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);");
        pm4.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);");
        t5.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);");
        payButton.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);");
        
        pm1.setFont(Font.font("Verdana", 16));
        pm2.setFont(Font.font("Verdana", 16));
        pm3.setFont(Font.font("Verdana", 16));
        pm4.setFont(Font.font("Verdana", 16));
        t5.setFont(Font.font("Verdana", 16));
        payButton.setFont(Font.font("Verdana", 16));
        msg1.setFont(Font.font("Verdana", 16));
        
        return root;
    }
}
