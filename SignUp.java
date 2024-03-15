package project;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.control.PasswordField;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Ghaida
 */
public class SignUp {

    //Buttons
    Button b1 = new Button("Back"); // log in
    Button b2 = new Button("Next"); //Home Page
    //Label for message 1
    Label msg1 = new Label();
    //TextFiles for sign up
    TextField t1 = new TextField();
    TextField t2 = new TextField();
    TextField t3 = new TextField();
    TextField t4 = new TextField();
    PasswordField t5 = new PasswordField();

    public SignUp() {
    }//Defult constructor

    public BorderPane suInt() {
        //GridePane for Sign uo profile
        GridPane profile = new GridPane();
        profile.setPadding(new Insets(20, 20, 20, 20));
        profile.add(new Label("Organization name: "), 0, 0);
        profile.add(t1, 1, 0);
        profile.add(new Label("Phone number: "), 0, 1);
        profile.add(t2, 1, 1);
        profile.add(new Label("Email: "), 0, 2);
        profile.add(t3, 1, 2);
        profile.add(new Label("International Securities Identification Number: "), 0, 3);
        profile.add(t4, 1, 3);
        profile.add(new Label("Password: "), 0, 4);
        profile.add(t5, 1, 4);
        profile.setHgap(10);
        profile.setVgap(10);
        //HBox for buttons
        HBox hboxForButtons = new HBox();
        hboxForButtons.setSpacing(30);
        hboxForButtons.setPadding(new Insets(40, 60, 60, 60));
        hboxForButtons.getChildren().addAll(b1, b2);
        hboxForButtons.setAlignment(Pos.BOTTOM_CENTER);
        //Root BorderPane
        BorderPane root = new BorderPane();
        root.setTop(profile);
        root.setCenter(msg1);
        root.setBottom(hboxForButtons);
        root.setStyle("-fx-background-color: rgb(112, 160, 175)");
        
        //Styling 
        b1.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);");
        b2.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);");
        t1.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);");
        t2.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);");
        t3.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);");
        t4.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);");
        t5.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);");
        
        b1.setFont(Font.font("Verdana", 16));
        b2.setFont(Font.font("Verdana", 16));
        t1.setFont(Font.font("Verdana", 16));
        t2.setFont(Font.font("Verdana", 16));
        t3.setFont(Font.font("Verdana", 16));
        t4.setFont(Font.font("Verdana", 16));
        t5.setFont(Font.font("Verdana", 16));
        return root;
    }

    //Boolean metood for valation sign up
    public boolean valdateSignUp() {
        msg1.setTextFill(Color.RED);
        if (t1.getText().isEmpty()) {
            msg1.setVisible(true);
            msg1.setText("Enter Organization Name: ");
            return false;
        } else if (t2.getText().isEmpty()) {
            msg1.setVisible(true);
            msg1.setText("Enter Phone Number: ");
            return false;
        } else if (t2.getText().length() != 10) {
            msg1.setVisible(true);
            msg1.setText("The Mobile Number Should Have Length 10");
            return false;
        } else if (t3.getText().isEmpty()) {
            msg1.setVisible(true);
            msg1.setText("Enter email");
            return false;
        } else if (t4.getText().isEmpty()) {
            msg1.setVisible(true);
            msg1.setText("Enter ISIN");
            return false;
        } else if (t5.getText().isEmpty()) {
            msg1.setVisible(true);
            msg1.setText("Enter Password");
            return false;
        }
        return true;
    }

    public String insertUser() {
        user newCustomer = new user();
        newCustomer.setOrganizationName(t1.getText());
        newCustomer.setPhoneNumber(Integer.parseInt(t2.getText()));
        newCustomer.setEmail(t3.getText());
        newCustomer.setISIN(Integer.parseInt(t4.getText()));
        newCustomer.setPassword(t5.getText());

        Session session = HibernateUtil.getSessionFactory().openSession();
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(newCustomer);
        tx.commit();
        session.close();
        
        return t1.getText();

    }

}
