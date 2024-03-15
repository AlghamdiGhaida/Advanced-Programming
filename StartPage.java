/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.util.Duration;

/**
 *
 * @author bllay
 */
public class StartPage {

    Button signupInStartPage;
    Button loginInStartPage;
    Label name;
    Label welcome;
    Color c0 = Color.rgb(241, 250, 238);
    Color c1 = Color.rgb(69, 123, 157);

    public StartPage() {
        this.signupInStartPage = new Button("Sign Up");
        this.loginInStartPage = new Button("Log In");
        this.name = new Label("\nSTRAVA!");
        this.welcome = new Label("\tWelcome to STRAVA!\n your virtual conference manager\t");

    }

    public BorderPane startpage() {
        //Styling
        name.setFont(Font.font("Verdana", FontPosture.REGULAR, 40));
        welcome.setFont(Font.font("Verdana", FontPosture.REGULAR, 20));
        signupInStartPage.setFont(Font.font("Verdana", FontPosture.REGULAR, 16));
        loginInStartPage.setFont(Font.font("Verdana", FontPosture.REGULAR, 16));

        name.setTextFill(c1);
        welcome.setTextFill(c0);
        loginInStartPage.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);");
        signupInStartPage.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);");
        name.setStyle("-fx-fill:RED; -fx-effect: dropshadow(gaussian, WHITE, 3,1.0, 0,0);");

        Image im = new Image("https://cdn-icons-png.flaticon.com/128/61/61205.png");
        ImageView imageView = new ImageView(im);
        imageView.setFitHeight(25);
        imageView.setFitWidth(25);
        loginInStartPage.setGraphic(imageView);
        loginInStartPage.setContentDisplay(ContentDisplay.LEFT);

        Image img = new Image("https://cdn-icons-png.flaticon.com/128/3917/3917709.png");
        ImageView imageView0 = new ImageView(img);
        imageView0.setFitHeight(25);
        imageView0.setFitWidth(25);
        signupInStartPage.setGraphic(imageView0);
        signupInStartPage.setContentDisplay(ContentDisplay.LEFT);

        //Animation
        Image star = new Image("https://cdn-icons-png.flaticon.com/128/9004/9004911.png");
        ImageView ivForStar = new ImageView(star);
        imageView0.setFitHeight(25);
        imageView0.setFitWidth(25);

        //Creating a rotate transition    
        RotateTransition rotateTransition = new RotateTransition();
        //Setting the duration for the transition 
        rotateTransition.setDuration(Duration.millis(5000));
        //Setting the node for the transition 
        rotateTransition.setNode(ivForStar);
        //Setting the angle of the rotation 
        rotateTransition.setByAngle(360);
        //Setting the cycle count for the transition 
        rotateTransition.setCycleCount(50);
        //Setting auto reverse value to false 
        rotateTransition.setAutoReverse(false);
        //Playing the animation 
        rotateTransition.play();

        //GUI
        VBox VBoxforButtons = new VBox(20);
        VBoxforButtons.getChildren().addAll(loginInStartPage, signupInStartPage);
        VBoxforButtons.setAlignment(Pos.CENTER);
        VBoxforButtons.setStyle("-fx-background-color: rgb(160, 193, 185)");
        VBoxforButtons.setPadding(new Insets(20, 20, 20, 20));

        VBox VBoxforLabel = new VBox(20);
        VBoxforLabel.getChildren().addAll(name, welcome, ivForStar);
        VBoxforLabel.setAlignment(Pos.TOP_CENTER);
        VBoxforLabel.setStyle("-fx-background-color: rgb(112, 160, 175)");

        BorderPane BPforStart = new BorderPane();
        BPforStart.setCenter(VBoxforButtons);
        BPforStart.setLeft(VBoxforLabel);
        BPforStart.setStyle("-fx-background-color: rgb(241, 250, 238)");
        return BPforStart;
    }

}
