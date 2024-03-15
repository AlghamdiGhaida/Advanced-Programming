/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.time.LocalDate;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.scene.text.TextAlignment;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Salma
 */
public class ReserveHall {

    BorderPane dsiplayCityPane = new BorderPane();
    BorderPane chooseHallborderPane = new BorderPane();
    Scene chooseHallScene = new Scene(chooseHallborderPane, 700, 650);
    ScrollPane ScrollPaneHall = new ScrollPane();

    Session session = HibernateUtil.getSessionFactory().openSession();
    //Used to insert halls int database
    ObservableList<hall> obHallDB = FXCollections.observableArrayList();
    List<hall> hallList = null;

    // Jeddah hall from index 0 to 5 until Leylaty // Riyadh hall from index 6 to 11 until Leylaty // Dubai hall from index 12 to 17 until Leylaty
    ObservableList<String> obHallName = FXCollections.observableArrayList("Moon", "bin sultan", "Sadim", "AlQasr", "Aldorrah", "Leylaty",
            "Mary", "Samara", "Crowne Plaza", "Serendipity", "Rosh Rayhan", "Al Ameera", "voco", "Hyatt Regency ", "Al Khayalah", "Al Mokmaleah");

    ObservableList<Integer> obHallNo = FXCollections.observableArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16);

    ObservableList<String> obHallSize = FXCollections.observableArrayList("550", "330", "450", "670", "480", "990", "880", "250", "340", "560", "400", "500", "800", "350", "600", "460");

    ObservableList<String> obHallStreet = FXCollections.observableArrayList("Shaikh Muhammad", "Al Latif", "Ashaikh Jaber", "Al Munsia",
            "Southern Ring Branch Rd", "King Salman", "King Abdullah", "AlNakheel", "Shaikh Muhammad", "Al Latif", "Ashaikh Jaber",
            "Al Munsia", "Southern Ring Branch Rd", "King Salman", "King Abdullah", "AlNakheel");

    ObservableList<String> obHallCity = FXCollections.observableArrayList("Jeddah", "Jeddah", "Jeddah", "Jeddah", "Jeddah", "Jeddah",
            "Riyadh", "Riyadh", "Riyadh", "Riyadh", "Riyadh", "Riyadh", "Dubai", "Dubai ", "Dubai", "Dubai");

    ObservableList<Integer> obHalldistFromAirport = FXCollections.observableArrayList(5, 15, 12, 6, 9, 4, 20, 30, 2, 3, 5, 7, 8, 12, 10, 11);

    ObservableList<Integer> obHalldistFromCC = FXCollections.observableArrayList(5, 3, 6, 7, 8, 9, 10, 2, 34, 5, 4, 8, 7, 9, 5, 4);

    ObservableList<Integer> obHallNoGates = FXCollections.observableArrayList(4, 3, 2, 4, 3, 2, 4, 2, 3, 3, 2, 2, 2, 3, 4, 5);

    ObservableList<Integer> obHallPrice = FXCollections.observableArrayList(15000, 20000, 10000, 4500, 5000, 13000, 20000, 3400, 7000, 8000,
            9500, 10500, 2000, 20000, 15000, 10500);

    ObservableList<String> obHallDescripition = FXCollections.observableArrayList("Moon Hall is a unique private event venue,\n the location is easy to reach and offers\n all event services to help you plan your event.",
            "bin sultan Hall for  events is located in Al Sulaimaniyah area\n it has luxuries halls and provides a great service for event .",
            "Sadim offers a range of suitable halls that are adaptable\n to your needs and equipped with state-of-the-art audio\n and light systems.\n Sadim offers 4 beautiful ballrooms each unique and elegant.",
            "AlQasr is a Hotel & Resort located in Jeddah,Saudi Arabia \nTop Organizers hosting events ",
            "Aldorrah Hall is a unique private event venue,\n the location is easy to reach and offers all event services\n to help you plan your event.",
            "Leylaty Hall makes for a strategic and convenient\n locale for every type of event and occasion, \naccommodating up to 2500 people.\nThe high ceilings, state-of-the-art equipment \nand cutting-edge technology make this address second to none.",
            "Mary Hall for  events is located in Al Sulaimaniyah area\n it has luxuries halls and provides a great service for event.",
            "Samara offers a range of suitable halls that are adaptable\n to your needs and equipped with state-of-the-art audio\n and light systems.\n Sadim offers 4 beautiful ballrooms each unique and elegant.",
            "Crowne Plaza Hall makes for a strategic and convenient\n locale for every type of event and occasion, \naccommodating up to 2500 people.\nThe high ceilings, state-of-the-art equipment \nand cutting-edge technology make this address second to none.",
            "Serendipity Hall is a unique private event venue,\n the location is easy to reach and offers\n all event services to help you plan your event.",
            "Rosh Rayhan offers a range of suitable halls that are adaptable\n to your needs and equipped with state-of-the-art audio\n and light systems.\n Sadim offers 4 beautiful ballrooms each unique and elegant.",
            "Al Ameera offers a range of suitable halls that are adaptable\n to your needs and equipped with state-of-the-art audio\n and light systems.\n Sadim offers 4 beautiful ballrooms each unique and elegant.",
            "voco offers a range of suitable halls that are adaptable\n to your needs and equipped with state-of-the-art audio\n and light systems.\n Sadim offers 4 beautiful ballrooms each unique and elegant.",
            "Hyatt Regency offers a range of suitable halls that are adaptable\n to your needs and equipped with state-of-the-art audio\n and light systems.\n Sadim offers 4 beautiful ballrooms each unique and elegant.",
            "Al Khayalah Hall is a unique private event venue,\n the location is easy to reach and offers\n all event services to help you plan your event.",
            "Al Mokmaleah Hall  for  events is located in Al Sulaimaniyah area\n it has luxuries halls and provides a great service for event .");

    ObservableList<Image> obhallImg = FXCollections.observableArrayList(new Image("https://eventective-media.azureedge.net/3357962_md.jpg"),
            new Image("https://f.hubspotusercontent40.net/hubfs/4416146/nycws-classroom-0028-hor-feat.jpg"),
            new Image("https://img.bizbash.com/files/base/bizbash/bzb/image/2019/09/Meeting_Classroom_Ballroom_0026.5d92446f6fe42.png?auto=format%2Ccompress&q=70&w=400"),
            new Image("https://eventective-media.azureedge.net/3494938_md.jpg"),
            new Image("https://eventective-media.azureedge.net/3397465_md.jpg"),
            new Image("https://images.adsttc.com/media/images/5808/2183/e58e/ce3c/6600/00f8/newsletter/166AE20161003D0078.jpg?1476927868"),
            new Image("https://images.adsttc.com/media/images/54f6/75ff/e58e/ce84/3100/015c/newsletter/052_CF016623b.jpg?1425438192"),
            new Image("https://www.geneve-int.ch/sites/default/files/styles/scale_1100/public/2019-09/Conference-CCV.jpg?itok=ncVm2SpY"),
            new Image("https://www.hkpcacademy.org/wp-content/uploads/2023/05/DSC04568Joyce_edited-scaled.jpg"),
            new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/3/34/European_Investment_Bank_anti-corruption_conference.jpg/450px-European_Investment_Bank_anti-corruption_conference.jpg"),
            new Image("https://thumbs.dreamstime.com/b/conference-hall-7641763.jpg"),
            new Image("https://thumbs.dreamstime.com/b/empty-conference-hall-18851712.jpg"),
            new Image("https://digital.ihg.com/is/image/ihg/voco-riyadh-6446509666-4x3"),
            new Image("https://eventective-media.azureedge.net/2530889_md.jpg"),
            new Image("https://www.icckyoto.or.jp/wp-content/uploads/2017/05/party-eventhall-1024x683.jpg"),
            new Image("https://www.singaporeflyer.com/storage/meeting-events/June2021/89sq2j37lOQJdeCmUeVX.png"),
            new Image("https://www.thefarmsoho.com/wp-content/uploads/2022/06/Kimpton-Marlowe-Hotel-1024x684.jpg"));

    ObservableList<hall> obHalls = FXCollections.observableArrayList();
    Label SelectCity = new Label("    Choose City   ");
    Label dateLB = new Label("Enter Date : ");
    Label hallInfoLB = new Label();
    Label msg = new Label("");

    ImageView riyadhIcon = new ImageView(new Image("https://cdn-icons-png.flaticon.com/128/88/88327.png"));
    ImageView jeddahIcon = new ImageView(new Image("https://cdn-icons-png.flaticon.com/128/2204/2204015.png"));
    ImageView dubaiIcon = new ImageView(new Image("https://cdn-icons-png.flaticon.com/128/4198/4198372.png"));

    Button riyadh = new Button(" Riyadh", riyadhIcon);
    Button jeddah = new Button(" Jeddah", jeddahIcon);
    Button dubai = new Button(" Dubai", dubaiIcon);

    Button Back = new Button("Back");
    DatePicker dateDP = new DatePicker();
    HBox dateHB = new HBox(30);
    VBox cityvB = new VBox(10);
    HBox chooseHallHB = new HBox(10);
    VBox displayHallVB = new VBox(10);
    String style1 = "-fx-background-color: rgba(69, 123, 157, 0.5);";
    String style11 = "-fx-background-color: rgba(255, 255, 255, 0.5);";
    String style = "-fx-background-color: rgb(69, 123, 157);";
    Font font = Font.font("Courier New", FontWeight.BOLD, 34);
    ScrollPane spForhall = new ScrollPane();
    
    //For retriving
    ObservableList<reservation> retObReservations = FXCollections.observableArrayList();
    List<reservation> retReservations = null;
    ObservableList<Integer> retObHallNo = FXCollections.observableArrayList();
    List<Integer> retHallNo = null;
    ObservableList<String> retObDates = FXCollections.observableArrayList();
    List<String> retdates = null;

    public ReserveHall() {
        
    }

    public Pane dsiplayCity() {

        /**
         * ********************** SELECT CITY PAGE
         * ******************************
         */
        dsiplayCityPane.setPadding(new Insets(50, 50, 50, 50));
        SelectCity.setTextFill(Color.rgb(29, 53, 87));
        SelectCity.setFont(Font.font("Courier New", FontWeight.BOLD, 28));
        dateLB.setFont(Font.font("Courier New", FontWeight.BOLD, 28));

        riyadh.setMaxSize(400, 300);
        jeddah.setMaxSize(400, 300);
        dubai.setMaxSize(400, 300);

        riyadh.setStyle(style11);
        jeddah.setStyle(style11);
        dubai.setStyle(style11);
        Back.setStyle(style11);
        riyadhIcon.setFitHeight(100);
        riyadhIcon.setFitWidth(100);
        jeddahIcon.setFitHeight(100);
        jeddahIcon.setFitWidth(100);
        dubaiIcon.setFitHeight(100);
        dubaiIcon.setFitWidth(100);

        riyadh.setContentDisplay(ContentDisplay.LEFT);
        jeddah.setContentDisplay(ContentDisplay.LEFT);
        dubai.setContentDisplay(ContentDisplay.LEFT);

        dateDP.setStyle("-fx-background-color: rgba(168, 218, 220, 0.5)");
        dubai.setFont(font);
        riyadh.setFont(font);
        jeddah.setFont(font);
        dateDP.setValue(LocalDate.now());

        dateHB.getChildren().addAll(dateLB, dateDP);
        dateHB.setAlignment(Pos.TOP_LEFT);
        cityvB.setSpacing(30);
        cityvB.setAlignment(Pos.CENTER);
        cityvB.setPadding(new Insets(10, 10, 10, 10));
        cityvB.getChildren().addAll(SelectCity, riyadh, jeddah, dubai);
        cityvB.setLayoutX(100);
        cityvB.setLayoutY(150);

        dsiplayCityPane.setTop(dateHB);
        dsiplayCityPane.setCenter(cityvB);
        /**
         * ********************** CHOOSE HALL PAGE
         * ******************************
         */
        Label ChooseHallLb = new Label("Choose Hall:   ");
        ChooseHallLb.setTextFill(Color.rgb(29, 53, 87));
        ChooseHallLb.setFont(font);

        chooseHallHB.setSpacing(200);
        chooseHallHB.setAlignment(Pos.CENTER);
        chooseHallHB.setPadding(new Insets(10, 10, 10, 10));
        chooseHallHB.getChildren().addAll(ChooseHallLb, Back);

        displayHallVB.setAlignment(Pos.CENTER);
        dsiplayCityPane.setStyle(style);
        return dsiplayCityPane;
    }
    //"Moon","bin sultan","Sadim","AlQasr","Aldorrah","Leylaty","Mary","Samara","Crowne Plaza","Serendipity","Rosh Rayhan","Al Ameera","voco","Hyatt Regency ","Al Khayalah","Al Mokmaleah")
    // JEDDAH HALL BUTTON 
    Button Moon = new Button("Reserve Moon Hall");
    Button binSultan = new Button("Reserve bin Sultan Hall");
    Button Sadim = new Button("Reserve Sadim Hall");
    Button AlQasr = new Button("Reserve AlQasr Hall");
    Button Aldorrah = new Button("Reserve Aldorrah Hall");
    Button Leylaty = new Button("Reserve Leylaty Hall");
    // RIYADH HALL BUTTON
    Button Mary = new Button("Reserve Mary Hall");
    Button Samara = new Button("Reserve Samara Hall");
    Button CrownePlaza = new Button("Reserve Crowne Plaza Hall");
    Button Serendipity = new Button("Reserve Serendipity Hall");
    Button RoshRayhan = new Button("Reserve Rosh Rayhan Hall");
    Button AlAmeera = new Button("Reserve Al-Ameera Hall");
    // DUBAI HALL BUTTON
    Button voco = new Button("Reserve Voco Hall");
    Button HyattRegency = new Button("Reserve Hyatt Regency Hall");
    Button AlKhayalah = new Button("Reserve Al-Khayalah Hall");
    Button AlMokmaleah = new Button("Reserve Al-Mokmaleah Hall");

    ObservableList<Button> obHallbtm = FXCollections.observableArrayList(Moon, binSultan, Sadim, AlQasr, Aldorrah, Leylaty, Mary, Samara, CrownePlaza, Serendipity, RoshRayhan, AlAmeera, voco, HyattRegency, AlKhayalah, AlMokmaleah);

    public VBox chooseHall(String hallInfo, Button hallbtn, ImageView img) {

        hallInfoLB = new Label(hallInfo, img);
        hallInfoLB.setContentDisplay(ContentDisplay.BOTTOM);
        hallInfoLB.setAlignment(Pos.CENTER);
        hallInfoLB.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);-fx-border-color: rgb(69, 123, 157); -fx-border-width: 3px;");
        hallbtn.setPrefHeight(70);
        hallbtn.setPrefWidth(500);
        hallbtn.setStyle(style);
        hallbtn.setFont(Font.font("Courier New", 16));
        displayHallVB.getChildren().addAll(hallInfoLB, new Label("Click on the left mouse button to zoom in the image and rigth Click button to zoom out\n "), hallbtn);
        displayHallVB.setStyle(style1);
        displayHallVB.setAlignment(Pos.CENTER);
        displayHallVB.setPadding(new Insets(15, 115, 15, 115));

        ScrollPaneHall.setContent(displayHallVB);
        ScrollPaneHall.setPadding(new Insets(0, 0, 0, 20));
        ScrollPaneHall.setStyle(style);
        chooseHallborderPane.setTop(chooseHallHB);
        chooseHallborderPane.setCenter(ScrollPaneHall);
        chooseHallborderPane.setStyle(style1);

        //Mouse Action 
        hallInfoLB.setOnMouseClicked(e -> {
            if (e.getButton() == MouseButton.PRIMARY) {
                img.setFitHeight(500);
                img.setFitWidth(600);
            }
            if (e.getButton() == MouseButton.SECONDARY) {
                img.setFitHeight(250);
                img.setFitWidth(450);
            }
        });

        return displayHallVB;

    }

    public void InsertHalls() {
//        session.beginTransaction();
//        String queryStr = "from hall";
//        Query query = session.createQuery(queryStr);
//        hallList = query.list();
//        obHallDB.setAll(hallList);
//        session.close();
        hall insertHall = new hall();
        for (int i = 0; i < obHallName.size(); i++) {
            insertHall.sethallName(obHallName.get(i));
            insertHall.setHallNo(obHallNo.get(i));
            insertHall.setSize(obHallSize.get(i));
            insertHall.setstreet(obHallStreet.get(i));
            insertHall.setcity(obHallCity.get(i));
            insertHall.setdistanceFromAirport(obHalldistFromAirport.get(i));
            insertHall.setdistanceFromCityCenter(obHalldistFromCC.get(i));
            insertHall.setnumOfGates(obHallNoGates.get(i));
            insertHall.sethallPrice(obHallPrice.get(i));
            Transaction tx = session.beginTransaction();
            session.save(insertHall);
            tx.commit();
            //session.close();
        }

    }

    public boolean valdateDate(int hallNumbertoValdet) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String queryStr0 = "from reservation";
        Query query0 = session.createQuery(queryStr0);
        retReservations = query0.list();
        retObReservations.setAll(retReservations);
        session.close();
        
        for(reservation r: retObReservations){
            retObHallNo.add(r.getHallNo());
            retObDates.add(r.getDate());
        }

        if (retObDates.contains(dateDP.getValue().toString()) && retObHallNo.contains(hallNumbertoValdet)) {
            msg.setText("Username doesn't exist / Username wrong");
            msg.setTextFill(Color.RED);
            Alert alertInformation = new Alert(AlertType.INFORMATION);
            alertInformation.setHeaderText("ERROR");
            alertInformation.setContentText("Hall is reservd at this date \n "
                    + "Change The date or choose another hall");
            alertInformation.showAndWait();
            return false;
        } else {
            return true;
        }

    }

}
