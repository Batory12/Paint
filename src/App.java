import javafx.stage.Stage;
import javafx.application.Application;
/**Klasa główna aplikacji
 */
public class App extends Application {
    /**
     * Metoda main
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }
    /**
     * Metoda start
     * @param stage
     */
    @Override
    public void start(Stage stage) {
        new GUI(stage);
    }
}
