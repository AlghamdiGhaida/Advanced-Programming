/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.util.List;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author bllay
 */
public class Project extends Application {

    @Override
    public void start(Stage primaryStage) {
        ObservableList<hall> retObHalls = FXCollections.observableArrayList();
        ObservableList<Integer> retObHallPrice = FXCollections.observableArrayList();
        ObservableList<Integer> retObHallNo = FXCollections.observableArrayList();
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<hall> retHalls = null;
        List<Integer> retHallPriceList = null;
        List<Integer> retHallNoList = null;
        //Test Databas

        reservation cusReservation = new reservation();

        //Start Page
        StartPage int00 = new StartPage();
        BorderPane root00 = int00.startpage();
        root00.setPadding(new Insets(20, 20, 20, 20));

        //Log in Interface
        LogIn int01 = new LogIn();
        BorderPane root01 = int01.login();
        root01.setPadding(new Insets(20, 20, 20, 20));

        //Sign up interface
        SignUp signupint = new SignUp();
        BorderPane signuproot = signupint.suInt();

        //Home Page
        Home homeObj = new Home();
        BorderPane HomePageInt = homeObj.mainInt();

        //Reserve interface
        ReserveHall Hall = new ReserveHall();
        //Hall.InsertHalls();

        //Handlers 
        Hall.riyadh.setOnAction(e -> {
            Hall.displayHallVB.getChildren().clear();
            int i = 6;
            for (; i <= 11; i++) {
                String hallInfo = "" + Hall.obHallDescripition.get(i)
                        + "\n\n More Details:\n Hall NO:" + Hall.obHallDB.get(i).getHallNo()
                        + "\n Hall Size: " + Hall.obHallDB.get(i).getSize() + "\n Street: "
                        + Hall.obHallDB.get(i).getstreet() + "\n Distance from Airport: "
                        + Hall.obHallDB.get(i).getdistanceFromAirport()
                        + "Km\n Distance from City Center: "
                        + Hall.obHallDB.get(i).getdistanceFromCityCenter()
                        + "Km\n Number of Gates: "
                        + Hall.obHallDB.get(i).getnumOfGates()
                        + "\n Hall Price: " + Hall.obHallDB.get(i).gethallPrice() + " SR";
                ImageView imgeview = new ImageView(Hall.obhallImg.get(i));
                imgeview.setFitHeight(250);
                imgeview.setFitWidth(450);
                Hall.chooseHall(hallInfo, Hall.obHallbtm.get(i), imgeview);
                primaryStage.setScene(Hall.chooseHallScene);
            }
        });

        Hall.dubai.setOnAction(e -> {
            Hall.displayHallVB.getChildren().clear();
            int i = 12;
            for (; i <= Hall.obHallName.size(); i++) {
                String hallInfo = "" + Hall.obHallDescripition.get(i)
                        + "\n\n More Details:\n Hall NO:" + Hall.obHallDB.get(i).getHallNo()
                        + "\n Hall Size: " + Hall.obHallDB.get(i).getSize() + "\n Street: "
                        + Hall.obHallDB.get(i).getstreet() + "\n Distance from Airport: "
                        + Hall.obHallDB.get(i).getdistanceFromAirport()
                        + "Km\n Distance from City Center: "
                        + Hall.obHallDB.get(i).getdistanceFromCityCenter()
                        + "Km\n Number of Gates: "
                        + Hall.obHallDB.get(i).getnumOfGates()
                        + "\n Hall Price: " + Hall.obHallDB.get(i).gethallPrice() + " SR";
                ImageView imgeview = new ImageView(Hall.obhallImg.get(i));
                imgeview.setFitHeight(250);
                imgeview.setFitWidth(450);
                Hall.chooseHall(hallInfo, Hall.obHallbtm.get(i), imgeview);
                primaryStage.setScene(Hall.chooseHallScene);
            }
        });

        Hall.jeddah.setOnAction(e -> {
            Hall.displayHallVB.getChildren().clear();
            //Hall.displayHallVB.getChildren().add(Hall.chooseHallHB);
            int i = 0;
            for (; i <= 5; i++) {
                String hallInfo = "" + Hall.obHallDescripition.get(i)
                        + "\n\n More Details:\n Hall NO:" + Hall.obHallDB.get(i).getHallNo()
                        + "\n Hall Size: " + Hall.obHallDB.get(i).getSize() + "\n Street: "
                        + Hall.obHallDB.get(i).getstreet() + "\n Distance from Airport: "
                        + Hall.obHallDB.get(i).getdistanceFromAirport()
                        + "Km\n Distance from City Center: "
                        + Hall.obHallDB.get(i).getdistanceFromCityCenter()
                        + "Km\n Number of Gates: "
                        + Hall.obHallDB.get(i).getnumOfGates()
                        + "\n Hall Price: " + Hall.obHallDB.get(i).gethallPrice() + " SR";

                ImageView imgeview = new ImageView(Hall.obhallImg.get(i));
                imgeview.setFitHeight(250);
                imgeview.setFitWidth(450);
                Hall.chooseHall(hallInfo, Hall.obHallbtm.get(i), imgeview);
                primaryStage.setScene(Hall.chooseHallScene);
            }
        });

        //Display reservation interface
        displayReservations displayReserve = new displayReservations();
        //Pane display = displayReserve.displayReserv();

        //Reservation information form interface
        Int06 int06 = new Int06();
        BorderPane root = int06.interface06();
        root.setPadding(new Insets(20, 20, 20, 20));

        //Pop up message for reservation verfication
        VBox pop = int06.popUp();

        //Payment
        Payment payObj = new Payment();
        BorderPane paymentroot = payObj.pay();

        //Scenes
        Scene startpage = new Scene(root00, 700, 450);
        Scene login = new Scene(root01, 700, 450);
        Scene signup = new Scene(signuproot, 700, 650);
        Scene home = new Scene(HomePageInt, 700, 650);
        Scene reservationForm = new Scene(root, 700, 650);
        Scene conformationMsg = new Scene(pop, 700, 350);
        Scene dsiplayCityScene = new Scene(Hall.dsiplayCity(), 700, 650);
        //Scene displayReservation = new Scene(display, 700, 650);
        Scene paymentint = new Scene(paymentroot, 700, 650);

        //Transions
        //StartPage to Login
        int00.loginInStartPage.setOnAction(e -> {
            primaryStage.setScene(login);
            primaryStage.setTitle("Log in");
        });

        //from StartPage to SignUp
        int00.signupInStartPage.setOnAction(e -> {
            primaryStage.setScene(signup);
            primaryStage.setTitle("Sign Up");

        });
        //from Login to Home Page
        int01.next.setOnAction(e -> {
            if (int01.valdateLogin() == true) {
                cusReservation.setOrganizationName(int01.TFusername.getText());
                primaryStage.setScene(home);
                primaryStage.setTitle("Home Page");
            }
        });

        //from Signup to HomePage
        signupint.b2.setOnAction(e -> {
            if (signupint.valdateSignUp() == true) {
                cusReservation.setOrganizationName(signupint.insertUser());
                primaryStage.setScene(home);
                primaryStage.setTitle("Home Page");
            }
        });
        //from HomePage to reserve
        homeObj.reserve.setOnAction(e -> {
            primaryStage.setScene(dsiplayCityScene);
            primaryStage.setTitle("Cities");
        });

        //from HomePage to Display Reservation
//        homeObj.display.setOnAction(e -> {
//            primaryStage.setScene(displayReservation);
//            primaryStage.setTitle("Cities");
//        });

        //from Display Reservation to HomePage
        displayReserve.homebtn.setOnAction(e -> {
            primaryStage.setScene(home);
            primaryStage.setTitle("Home Page");
        });

        //from ChooseHalls scene to DisplayCity
        Hall.Back.setOnAction(e -> {
            primaryStage.setScene(dsiplayCityScene);
        });

        //From chooseHall to Reservation Form
        //Retrive hall information 
        session.beginTransaction();
        String queryStr0 = "from hall";
        Query query0 = session.createQuery(queryStr0);
        retHalls = query0.list();
        retObHalls.setAll(retHalls);
        Hall.obHallDB.setAll(retHalls);
        session.close();

        //Get hallNumber and price and save them into obList
        for (hall h : retObHalls) {
            retObHallPrice.add(h.gethallPrice());
            retObHallNo.add(h.getHallNo());
        }

        Hall.Moon.setOnAction(e -> {
            if (Hall.valdateDate(0) == true) {
                cusReservation.setTotalPrice(retObHallPrice.get(0));
                cusReservation.setHallNo(retObHallNo.get(0));
                primaryStage.setScene(reservationForm);
            }
        });

        Hall.binSultan.setOnAction(e -> {
            if (Hall.valdateDate(1) == true) {
                cusReservation.setTotalPrice(retObHallPrice.get(1));
                cusReservation.setHallNo(retObHallNo.get(1));
                cusReservation.setDate(Hall.dateDP.getValue().toString());
                primaryStage.setScene(reservationForm);
            }
        });

        Hall.Sadim.setOnAction(e -> {
            if (Hall.valdateDate(2) == true) {
                cusReservation.setTotalPrice(retObHallPrice.get(2));
                cusReservation.setHallNo(retObHallNo.get(2));
                cusReservation.setDate(Hall.dateDP.getValue().toString());
                primaryStage.setScene(reservationForm);
            }
        });

        Hall.AlQasr.setOnAction(e -> {
            if (Hall.valdateDate(3) == true) {
                cusReservation.setTotalPrice(retObHallPrice.get(3));
                cusReservation.setHallNo(retObHallNo.get(3));
                cusReservation.setDate(Hall.dateDP.getValue().toString());
                primaryStage.setScene(reservationForm);
            }
        });

        Hall.Aldorrah.setOnAction(e -> {
            if (Hall.valdateDate(4) == true) {
                cusReservation.setTotalPrice(retObHallPrice.get(4));
                cusReservation.setHallNo(retObHallNo.get(4));
                cusReservation.setDate(Hall.dateDP.getValue().toString());
                primaryStage.setScene(reservationForm);
            }
        });

        Hall.Leylaty.setOnAction(e -> {
            if (Hall.valdateDate(5) == true) {
                cusReservation.setTotalPrice(retObHallPrice.get(5));
                cusReservation.setHallNo(retObHallNo.get(5));
                cusReservation.setDate(Hall.dateDP.getValue().toString());
                primaryStage.setScene(reservationForm);
            }
        });

        Hall.Mary.setOnAction(e -> {
            if (Hall.valdateDate(6) == true) {
                cusReservation.setTotalPrice(retObHallPrice.get(6));
                cusReservation.setHallNo(retObHallNo.get(6));
                cusReservation.setDate(Hall.dateDP.getValue().toString());
                primaryStage.setScene(reservationForm);
            }
        });

        Hall.Samara.setOnAction(e -> {
            if (Hall.valdateDate(7) == true) {
                cusReservation.setTotalPrice(retObHallPrice.get(7));
                cusReservation.setHallNo(retObHallNo.get(7));
                cusReservation.setDate(Hall.dateDP.getValue().toString());
                primaryStage.setScene(reservationForm);
            }
        });

        Hall.CrownePlaza.setOnAction(e -> {
            if (Hall.valdateDate(8) == true) {
                cusReservation.setTotalPrice(retObHallPrice.get(8));
                cusReservation.setHallNo(retObHallNo.get(8));
                cusReservation.setDate(Hall.dateDP.getValue().toString());
                primaryStage.setScene(reservationForm);
            }
        });

        Hall.Serendipity.setOnAction(e -> {
            if (Hall.valdateDate(9) == true) {
                cusReservation.setTotalPrice(retObHallPrice.get(9));
                cusReservation.setHallNo(retObHallNo.get(9));
                cusReservation.setDate(Hall.dateDP.getValue().toString());
                primaryStage.setScene(reservationForm);
            }
        });

        Hall.RoshRayhan.setOnAction(e -> {
            if (Hall.valdateDate(10) == true) {
                cusReservation.setTotalPrice(retObHallPrice.get(10));
                cusReservation.setHallNo(retObHallNo.get(10));
                cusReservation.setDate(Hall.dateDP.getValue().toString());
                primaryStage.setScene(reservationForm);
            }
        });

        Hall.AlAmeera.setOnAction(e -> {
            if (Hall.valdateDate(11) == true) {
                cusReservation.setTotalPrice(retObHallPrice.get(11));
                cusReservation.setHallNo(retObHallNo.get(11));
                cusReservation.setDate(Hall.dateDP.getValue().toString());
                primaryStage.setScene(reservationForm);
            }
        });

        Hall.voco.setOnAction(e -> {
            if (Hall.valdateDate(12) == true) {
                cusReservation.setTotalPrice(retObHallPrice.get(12));
                cusReservation.setHallNo(retObHallNo.get(12));
                cusReservation.setDate(Hall.dateDP.getValue().toString());
                primaryStage.setScene(reservationForm);
            }
        });

        Hall.HyattRegency.setOnAction(e -> {
            if (Hall.valdateDate(13) == true) {
                cusReservation.setTotalPrice(retObHallPrice.get(13));
                cusReservation.setHallNo(retObHallNo.get(13));
                cusReservation.setDate(Hall.dateDP.getValue().toString());
                primaryStage.setScene(reservationForm);
            }
        });

        Hall.AlKhayalah.setOnAction(e -> {
            if (Hall.valdateDate(14) == true) {
                cusReservation.setTotalPrice(retObHallPrice.get(14));
                cusReservation.setHallNo(retObHallNo.get(14));
                cusReservation.setDate(Hall.dateDP.getValue().toString());
                primaryStage.setScene(reservationForm);
            }
        });

        Hall.AlMokmaleah.setOnAction(e -> {
            if (Hall.valdateDate(15) == true) {
                cusReservation.setTotalPrice(retObHallPrice.get(15));
                cusReservation.setHallNo(retObHallNo.get(15));
                cusReservation.setDate(Hall.dateDP.getValue().toString());
                primaryStage.setScene(reservationForm);
            }
        });

        //from reservation information to payment
        int06.next.setOnAction(e -> {
            if (int06.valdateForm() == true) {
                primaryStage.setScene(paymentint);
                primaryStage.setTitle("Payment");
            }
        });

        //from payment to pop
        payObj.payButton.setOnAction(e -> {
            if (payObj.valdatePayment() == true) {
                //add to the database
                int06.insertReservation(cusReservation);
                primaryStage.setScene(conformationMsg);
                primaryStage.setTitle("Conformation Pop up Message");
            }
        });

        //from conformation pop message to HomePage 
        int06.home.setOnAction(e -> {
            primaryStage.setScene(home);
            primaryStage.setTitle("Home Page");
        });

        primaryStage.setTitle("Start Page");
        primaryStage.setScene(startpage);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
