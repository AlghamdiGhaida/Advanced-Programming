package project;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;


public class Home {
    Button reserve = new Button("Reserve");
    Button cancle = new Button("Cancel Reserve");
    Button display = new Button("Display Reservation");
    
    public Home(){
        reserve.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);");
        cancle.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);");
        display.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);");
    }
    
    public BorderPane mainInt(){
        //Right Rectangle
        Rectangle r2 = new Rectangle();
        Color c0 = Color.rgb(168, 218, 220);
        r2.setFill(c0);
        r2.setHeight(750);
        r2.setWidth(200);
       
        //Big Text
        Text t1 = new Text("Premium Halls");
        t1.setFont(Font.font("Verdana", FontWeight.BOLD, 40));
        //small Text
        Text t2 = new Text("All meeting holls and rooms are designed to"
                + " the highest standards of interior styling,\n" +
                "With SYRAVA holl, you can book meeting holls,"
                + " boardrooms and resources instantly - \n" +
                "whenever and wherever you like.");
        t2.setFont(Font.font("Verdana", FontWeight.NORMAL, 12));
        //VBox for texts
        VBox vboxForTexts = new VBox(30);
        vboxForTexts.getChildren().addAll(t1,t2);
        vboxForTexts.setPadding(new Insets(30, 30, 30, 30));
        //StackPane for the rectangle and text
        StackPane topStack = new StackPane();
        topStack.getChildren().addAll(vboxForTexts);
        //Image
        Image image1 = new Image("https://i.pinimg.com/564x/e0/84/7e/e0847ee63b6ebcd57037a2237d656bb9.jpg");
        ImageView i1 = new ImageView(image1);
        i1.setX(150);
        i1.setY(1);
        i1.setFitHeight(800);
        i1.setFitWidth(500);
        i1.effectProperty();
        //Reserve button
        reserve.setMaxHeight(100);
        reserve.setMaxWidth(300);
        reserve.setMinHeight(100);
        reserve.setMinWidth(300);
        reserve.setFont(Font.font("Verdana", FontWeight.NORMAL,15));
        reserve.setStyle("-fx-background-color: rgb(255, 255, 255, 0.5)");
        //Cancel Reserve button
        cancle.setMaxHeight(100);
        cancle.setMaxWidth(300);
        cancle.setMinHeight(100);
        cancle.setMinWidth(300);
        cancle.setFont(Font.font("Verdana", FontWeight.NORMAL,15));
        cancle.setStyle("-fx-background-color: rgb(255, 255, 255, 0.5)");
        //Display Reservation
        display.setMaxHeight(100);
        display.setMaxWidth(300);
        display.setMinHeight(100);
        display.setMinWidth(300);
        display.setFont(Font.font("Verdana", FontWeight.NORMAL,15));
        display.setStyle("-fx-background-color: rgb(255, 255, 255, 0.5)");
        //VBox for buttons
        VBox vboxButtons = new VBox(10);
        vboxButtons.setPadding(new Insets(20,20, 20, 20));
        vboxButtons.getChildren().addAll( reserve, cancle, display);
        
        //StackPane for image and VBox
        StackPane stackForimage = new StackPane();
        stackForimage.getChildren().addAll(i1, vboxButtons);
        
        //Root BorderPane
        BorderPane root = new BorderPane();
        root.setTop(topStack);
        topStack.setStyle("-fx-background-color: rgb(160, 193, 185)");
        root.setStyle("-fx-background-color: rgb(160, 193, 185)");
        
        root.setCenter(stackForimage);
        

        HBox right = new HBox();
        right.setStyle("-fx-background-color: rgb(168, 218, 220)");
        right.getChildren().add(r2);
        root.setRight(right);
        return root;
    } 
}