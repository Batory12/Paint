import javafx.stage.Stage;
import javafx.application.Application;
public class App extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) {
        new GUI(stage);
    }
}
