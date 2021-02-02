package pacman;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pacman.UI.Controller;

public class Pacman extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("pacman.fxml"));
        Parent root = loader.load();
        Controller controller = loader.getController();
        root.setOnKeyPressed(controller);
        primaryStage.setTitle("Pacman");
        primaryStage.setScene(new Scene(root, 650, 650));
        primaryStage.show();
        root.requestFocus();
//        primaryStage.setOnCloseRequest(e -> Platform.exit());
    }

    public static void main(String[] args) {
        launch(args);
    }
}
