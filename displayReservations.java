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
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Salma
 */
public class displayReservations {

    Button homebtn = new Button("Home");
    Session session = HibernateUtil.getSessionFactory().openSession();
    ObservableList<reservation> retObReservations = FXCollections.observableArrayList();
    List<reservation> retReservations = null;

    public displayReservations() {
        //Styling
        Image image = new Image("https://cdn-icons-png.flaticon.com/128/3917/3917032.png");
        ImageView iv = new ImageView(image);
        iv.setFitHeight(20);
        iv.setFitWidth(20);
        homebtn.setGraphic(iv);
        homebtn.setContentDisplay(ContentDisplay.TOP);
        Color c0 = Color.rgb(168, 218, 220);
        homebtn.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);");

    }

    public Pane displayReserv() {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String queryStr0 = "from reservation";
        Query query0 = session.createQuery(queryStr0);
        retReservations = query0.list();
        retObReservations.setAll(retReservations);
        session.getTransaction().commit();
        session.close();

        Label lb1 = new Label("Enter Reservation Number:");
        TextField tf = new TextField();

        reservation displayCusReservations = null;
//        int idReservationNo = Integer.parseInt(tf.getText());

        displayCusReservations = retObReservations.get(retObReservations.indexOf(tf.getText()));

        String invoice = "Reservation " + tf.getText() + " Details: "
                + "\nOrganization Name: " + displayCusReservations.getOrganizationName()
                + "\nConference Type: " + displayCusReservations.getConferenceType()
                + "\nDate: " + displayCusReservations.getDate()
                + "\nHall Number: " + displayCusReservations.getHallNo()
                + "\nGuests Number: " + displayCusReservations.getGuestsNo()
                + "\nServices: " + displayCusReservations.getservices()
                + "\nTotal Price: " + displayCusReservations.getTotalPrice();

        Text totalInvoice = new Text(50, 100, invoice);

        Button printInvoice = new Button("Enter");

        Text alertCutomerInfoS2 = new Text("");
        alertCutomerInfoS2.setFill(Color.RED);

        HBox phoneNo = new HBox(10);
        phoneNo.setAlignment(Pos.TOP_LEFT);
        phoneNo.getChildren().addAll(lb1, tf, alertCutomerInfoS2, printInvoice, homebtn);
        VBox phoneNoWithAlert = new VBox(phoneNo, alertCutomerInfoS2);
        phoneNoWithAlert.setSpacing(20);
        phoneNoWithAlert.setPadding(new Insets(0, 0, 20, 0));

        Pane pane = new Pane();
        pane.setPadding(new Insets(80, 80, 80, 80));
        pane.setStyle("-fx-background-color: rgb(254, 250, 224);-fx-border-color: rgb(168, 218, 220); -fx-border-width: 5px;-fx-text-fill: rgb(241, 250, 238);");

        totalInvoice.setFont(Font.font("verdana", FontWeight.THIN, FontPosture.REGULAR, 20));
        pane.getChildren().add(totalInvoice);

        BorderPane porder = new BorderPane();
        porder.setPadding(new Insets(50, 50, 50, 50));
        porder.setTop(phoneNoWithAlert);
        porder.setCenter(pane);

        return porder;

    }
}
