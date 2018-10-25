import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
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
        Text advice = new Text("");
        root.getChildren().add(advice);

        Text bigO = new Text("Brute force is of big O a^n, common password is of big O k (a constant)\nand the secret strat is of big O k");
        bigO.setLayoutY(300);
        bigO.setLayoutX(50);
        root.getChildren().add(bigO);

        stage.setScene(new Scene(root, 500, 500));
        stage.show();
        Button1.setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent e){
                bigO.setText("");
                String toGuess = password.getText();
                Logic password = new Logic(toGuess);
                System.out.print(password.bruteForce());
                if(password.bruteForce()==1){
                    advice.setText("Your password was too short, try making a longer password.");
                    advice.setLayoutY(300);
                    advice.setLayoutX(50);


                }
                else{
                    advice.setText("Your password could not be guessed, you are unhackable!");
                    advice.setLayoutY(300);
                    advice.setLayoutX(50);

                }
            }
        });

        Button2.setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent e){
                bigO.setText("");
                String toGuess = password.getText();
                Logic password = new Logic(toGuess);
                System.out.print(password.commonPasswords());
                if(password.commonPasswords()==1){
                    advice.setText("Your password was too common, try making a unique password.");
                    advice.setLayoutY(300);
                    advice.setLayoutX(50);


                }
                else{
                    advice.setText("Your password could not be guessed, you are unhackable!");
                    advice.setLayoutY(300);
                    advice.setLayoutX(50);

                }
            }
        });
        Button3.setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent e){
                bigO.setText("");
                String toGuess = password.getText();
                Logic password = new Logic(toGuess);
                System.out.print(password.commonCharacters());
                if(password.commonCharacters()==1){
                    advice.setText("Your password was too common even with the replacements, try making a unique password.");
                    advice.setLayoutY(300);
                    advice.setLayoutX(50);


                }
                else{
                    advice.setText("Your password could not be guessed, you are unhackable!");
                    advice.setLayoutY(300);
                    advice.setLayoutX(50);

                }
            }
        });


            }

        }



