/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author bllay
 */
public class LogIn {

    Label usernameLabel;
    TextField TFusername;
    Label passwordLabel;
    PasswordField PFpassword;
    Button su;
    Button next;
    Label msg = new Label("");
    ObservableList<user> obUser = FXCollections.observableArrayList();
    ObservableList<String> obUsername = FXCollections.observableArrayList();
    ObservableList<String> obPassword = FXCollections.observableArrayList();
    Session session = HibernateUtil.getSessionFactory().openSession();
    List<user> uList = null;
        

    public LogIn() {
        this.usernameLabel = new Label("Username:");
        this.TFusername = new TextField();
        this.passwordLabel = new Label("Password");
        this.PFpassword = new PasswordField();
        this.su = new Button("Sing Up");
        this.next = new Button("Next");
    }

    public BorderPane login() {
        //Styling
        Image im = new Image("https://cdn-icons-png.flaticon.com/128/3917/3917008.png");
        ImageView imageView = new ImageView(im);
        imageView.setFitHeight(20);
        imageView.setFitWidth(20);
        next.setGraphic(imageView);
        next.setContentDisplay(ContentDisplay.RIGHT);
        
        Image img = new Image("https://cdn-icons-png.flaticon.com/128/3917/3917709.png");
        ImageView imageView0 = new ImageView(img);
        imageView0.setFitHeight(20);
        imageView0.setFitWidth(20);
        su.setGraphic(imageView0);
        su.setContentDisplay(ContentDisplay.LEFT);
        
        msg.setFont(Font.font("Verdana", FontPosture.REGULAR, 16));
        usernameLabel.setFont(Font.font("Verdana", FontPosture.REGULAR, 16));
        passwordLabel.setFont(Font.font("Verdana", FontPosture.REGULAR, 16));
        su.setFont(Font.font("Verdana", FontPosture.REGULAR, 14));
        next.setFont(Font.font("Verdana", FontPosture.REGULAR, 14));
        
        TFusername.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);");
        PFpassword.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);");
        su.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);");
        next.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);");
        
        TFusername.setMaxSize(140, 20);
        PFpassword.setMaxSize(140, 20);
        
        //Database
        session.beginTransaction();
        String queryStr = "from user";
        Query query = session.createQuery(queryStr);
        uList = query.list();
        obUser.setAll(uList);
        session.close();
        
        for(user u: obUser){
            obUsername.add(u.getOrganizationName());
            obPassword.add(u.getPassword());
        }
        
        //GUI
        GridPane GPforlogin = new GridPane();
        GPforlogin.setPadding(new Insets(20, 20, 20, 20));
        GPforlogin.setVgap(10);
        GPforlogin.setHgap(10);
        GPforlogin.add(usernameLabel, 0, 0);
        GPforlogin.add(TFusername, 1, 0);
        GPforlogin.add(passwordLabel, 0, 1);
        GPforlogin.add(PFpassword, 1, 1);
        GPforlogin.add(msg, 1, 3);
        GPforlogin.setAlignment(Pos.CENTER);
        
        HBox HboxforButtons = new HBox();
        HboxforButtons.setPadding(new Insets(40, 60, 60, 60));
        HboxforButtons.setSpacing(30);
        HboxforButtons.getChildren().addAll(su, next);
        HboxforButtons.setAlignment(Pos.BOTTOM_CENTER);
        
        BorderPane root = new BorderPane();
        root.setCenter(GPforlogin);
        root.setBottom(HboxforButtons);
        root.setStyle("-fx-background-color: rgb(112, 160, 175)");
        

        return root;
    }
    
    public boolean valdateLogin(){
        if(TFusername.getText().equals("")){
            msg.setText("Plaese Enter your username");
            msg.setTextFill(Color.RED);
            return false;
        }else if(PFpassword.getText().equals("")){
            msg.setText("Plaese Enter your password");
            msg.setTextFill(Color.RED);
            return false;
        }else if(!(obUsername.contains(TFusername.getText()))){
            msg.setText("Username doesn't exist / Username wrong");
            msg.setTextFill(Color.RED);
            return false;
        }else if(!(obPassword.contains(PFpassword.getText()))){
            msg.setText("Password is wrong");
            msg.setTextFill(Color.RED);
            return false;
        }
        return true;
    }
}
