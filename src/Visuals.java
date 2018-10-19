import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Visuals extends Application {
    public static void main(String[] args){
        launch(args);
    }
    public void start(Stage stage){

        Group root = new Group();
        stage.setTitle("xX_SUP4_H4CK3R_Xx");

        Label pass = new Label("Password: ");
        TextField password = new TextField();
        password.setLayoutX(75);
        HBox space = new HBox();
        space.getChildren().addAll(pass, password);
        space.setSpacing(10);
        space.setLayoutX(10);
        root.getChildren().add(password);
        root.getChildren().add(space);

        Button Button1 = new Button("Brute-Force");
        Button1.setLayoutX(50);
        Button1.setLayoutY(150);
        root.getChildren().add(Button1);

        Button Button2 = new Button("Common Password");
        Button2.setLayoutX(325);
        Button2.setLayoutY(150);
        root.getChildren().add(Button2);

        Button Button3 = new Button("Secret Strats");
        Button3.setLayoutX(185);
        Button3.setLayoutY(75);
        root.getChildren().add(Button3);

        Button submit= new Button("Submit");
        submit.setLayoutX(250);
        root.getChildren().add(submit);


        stage.setScene(new Scene(root, 500, 500));
        stage.show();
        submit.setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent e){
                String toGuess = password.getText();
                System.out.print(toGuess);
            }
        });


            }

        }



