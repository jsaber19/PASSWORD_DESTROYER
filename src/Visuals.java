import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Visuals extends Application {
    public static void main(String[] args){
        launch(args);
    }
    public void start(Stage stage){
        Group root = new Group();
        Button Button1 = new Button("Brute-Force");
        Button1.setLayoutX(50);
        Button1.setLayoutY(150);
        root.getChildren().add(Button1);

        stage.setScene(new Scene(root, 500, 500));
        stage.show();
    }
}
