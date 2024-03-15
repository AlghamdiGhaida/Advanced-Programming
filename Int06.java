/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.io.FileInputStream;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


/**
 *
 * @author bllay
 */
public class Int06 {

    Label gn;
    TextField gnf;
    Label ct;
    RadioButton Pressbtn;
    RadioButton ProductLaunchesbtn;
    RadioButton Workshopbtn;
    RadioButton Seminarbtn;
    RadioButton Colloquiumbtn;
    ToggleGroup group;
    Button next;
    Label services;
    CheckBox hostch;
    CheckBox checkPointch;
    CheckBox waitersch;
    CheckBox BGch;
    CheckBox PVch;
    CheckBox buffet;
    int reserveNum;
    Button home;
    Button Back;
    Label msg = new Label("");
    ObservableList<Integer> obReservation = FXCollections.observableArrayList();
    Session session = HibernateUtil.getSessionFactory().openSession();
    List<Integer> rList = null;

    public Int06() {
        this.next = new Button("Next");
        this.Back = new Button("Back");
        this.home = new Button("Home Page");
        this.gn = new Label("Guests Number:");
        this.gnf = new TextField();
        this.ct = new Label("Conference Type:");
        this.Pressbtn = new RadioButton("Press");
        this.ProductLaunchesbtn = new RadioButton("Product Launch");
        this.Workshopbtn = new RadioButton("Workshop");
        this.Seminarbtn = new RadioButton("Seminar");
        this.Colloquiumbtn = new RadioButton("Colloquium");;
        this.group = new ToggleGroup();
        this.services = new Label("Services:");
        this.hostch = new CheckBox("Host");
        this.checkPointch = new CheckBox("Checkpoint");
        this.waitersch = new CheckBox("Witers");
        this.BGch = new CheckBox("Bodygaurds");
        this.PVch = new CheckBox("Parking Valet");
        this.buffet = new CheckBox("Buffet");
        this.reserveNum = (int) (1000 + Math.random() * 4001); //range =(1000-5000)

    }

    public BorderPane interface06() {
        //Styling
        gn.setFont(Font.font("Verdana", FontPosture.REGULAR, 16));
        ct.setFont(Font.font("Verdana", FontPosture.REGULAR, 16));
        Pressbtn.setFont(Font.font("Verdana", FontPosture.REGULAR, 14));
        ProductLaunchesbtn.setFont(Font.font("Verdana", FontPosture.REGULAR, 14));
        Workshopbtn.setFont(Font.font("Verdana", FontPosture.REGULAR, 14));
        Seminarbtn.setFont(Font.font("Verdana", FontPosture.REGULAR, 14));
        Colloquiumbtn.setFont(Font.font("Verdana", FontPosture.REGULAR, 14));
        services.setFont(Font.font("Verdana", FontPosture.REGULAR, 16));
        hostch.setFont(Font.font("Verdana", FontPosture.REGULAR, 14));
        checkPointch.setFont(Font.font("Verdana", FontPosture.REGULAR, 14));
        waitersch.setFont(Font.font("Verdana", FontPosture.REGULAR, 14));
        BGch.setFont(Font.font("Verdana", FontPosture.REGULAR, 14));
        PVch.setFont(Font.font("Verdana", FontPosture.REGULAR, 14));
        buffet.setFont(Font.font("Verdana", FontPosture.REGULAR, 14));
        next.setFont(Font.font("Verdana", FontPosture.REGULAR, 14));
        msg.setFont(Font.font("Verdana", FontPosture.REGULAR, 16));
       
        next.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);");
        Back.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);");
        gnf.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);");
        
        Image im = new Image("https://cdn-icons-png.flaticon.com/128/3917/3917008.png");
        ImageView imageView = new ImageView(im);
        imageView.setFitHeight(20);
        imageView.setFitWidth(20);
        next.setGraphic(imageView);
        next.setContentDisplay(ContentDisplay.RIGHT);

        //Declaring the main layout pane
        BorderPane lo = new BorderPane();
        GridPane main = new GridPane();
        main.setHgap(20);
        main.setVgap(20);

        //VBox for cell 0,0
        VBox main00 = new VBox(10);
        VBox main01 = new VBox(10);

        //Declaring HBox for the RadioButtons
        HBox forConType = new HBox(7);

        //Putting the RadioButtons into a TogglrGroup
        Pressbtn.setToggleGroup(group);
        ProductLaunchesbtn.setToggleGroup(group);
        Workshopbtn.setToggleGroup(group);
        Seminarbtn.setToggleGroup(group);
        Colloquiumbtn.setToggleGroup(group);

        //Adding the RadioButtons into the HBox
        forConType.getChildren().addAll(Pressbtn, ProductLaunchesbtn, Workshopbtn, Seminarbtn, Colloquiumbtn);

        //Adding nodes to the VBox main00
        main00.getChildren().addAll(gn, gnf, ct, forConType);

        //Adding nodes to the VBox main01
        main01.getChildren().addAll(services, hostch, checkPointch, waitersch, BGch, PVch, buffet);

        //Adding the node into the GridPane
        main.add(main00, 0, 0);
        main.add(main01, 0, 1);
        main.add(msg, 0, 2);

        HBox fornextBack = new HBox(20);
        fornextBack.getChildren().addAll(next, Back);
        lo.setCenter(main);
        lo.setBottom(fornextBack);
        lo.setStyle("-fx-background-color: rgb(112, 160, 175)");

        return lo;
    }

    public VBox popUp() {
        //Styling
        Image image = new Image("https://cdn-icons-png.flaticon.com/128/3917/3917032.png");
        ImageView iv = new ImageView(image);
        iv.setFitHeight(20);
        iv.setFitWidth(20);
        home.setGraphic(iv);
        home.setContentDisplay(ContentDisplay.TOP);
        Color c0 = Color.rgb(168, 218, 220);
        home.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);");
        
        //GUI
        VBox msg = new VBox(20);
        Image img = new Image("https://cdn-icons-png.flaticon.com/128/3472/3472620.png");
        ImageView ver = new ImageView(img);
        ver.setX(50);
        ver.setY(60);
        ver.setFitHeight(80);
        ver.setFitWidth(80);

        Label verL = new Label("Dear Customer\nYour reservation has been successfully made\n"
                + "This is your reservation number: " + reserveNum
                + "\nTo get all of your reservation information please go to Display Reservation");
        verL.setAlignment(Pos.CENTER);
        verL.setFont(Font.font("Verdana", FontPosture.REGULAR, 16));

        msg.getChildren().addAll(ver, verL, home);
        msg.setAlignment(Pos.CENTER);
        msg.setStyle("-fx-background-color: rgb(112, 160, 175)");
        return msg;
    }

    public boolean valdateForm() {
        if (gnf.getText().equals("")) {
            msg.setText("Please enter number of guests");
            msg.setTextFill(Color.RED);
            return false;
        } else if (!(Pressbtn.isSelected()) & !(ProductLaunchesbtn.isSelected())
                & !(Workshopbtn.isSelected()) & !(Seminarbtn.isSelected())
                & !(Colloquiumbtn.isSelected())) {
            msg.setText("Please choose conference type");
            msg.setTextFill(Color.RED);
            return false;
        } else if (!(hostch.isSelected()) & !(checkPointch.isSelected()) & !(waitersch.isSelected())
                & !(BGch.isSelected()) & !(PVch.isSelected()) & !(buffet.isSelected())) {
            msg.setText("Please choose at least one service");
            msg.setTextFill(Color.RED);
            return false;
        }
        return true;
    }
    
    public void insertReservation(reservation cusReservation){
        String services = "";
        //Datbase
        session.beginTransaction();
        String queryStr = "select reservationNo from reservation";
        Query query = session.createQuery(queryStr);
        rList = query.list();
        obReservation.setAll(rList);
        session.close();
        
        
        if(!(obReservation.contains(reserveNum))){
            cusReservation.setreservationNo(reserveNum);
        } else{
            reserveNum = (int) (1000 + Math.random() * 4001); //range =(1000-5000)
            cusReservation.setreservationNo(reserveNum);
        }
        
        if(Pressbtn.isSelected()){
          cusReservation.setConferenceType("Press");  
        } else if(ProductLaunchesbtn.isSelected()){
            cusReservation.setConferenceType("Product Launch");  
        } else if(Workshopbtn.isSelected()){
            cusReservation.setConferenceType("Workshop");  
        } else if(Seminarbtn.isSelected()){
            cusReservation.setConferenceType("Seminar"); 
        } else if(Colloquiumbtn.isSelected()){
            cusReservation.setConferenceType("Colloquium");
        }
        
        if(hostch.isSelected()){
            services+="Host";
        } else if(checkPointch.isSelected()){
            services+="CheckPoint";
        } else if(waitersch.isSelected()){
            services+="Waiters";
        }else if(BGch.isSelected()){
            services+="Bodygaurds";
        }else if(PVch.isSelected()){
            services+="Parking Valet";
        }else if(buffet.isSelected()){
            services+="Buffet";
        }
        cusReservation.setservices(services);
        cusReservation.setGuestsNo(Integer.parseInt(gnf.getText()));
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(cusReservation);
        tx.commit();
        session.close();
        
    }

}
