import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
public class GUI {
    public GUI(Stage stage) {
        BorderPane root = new BorderPane();
        Plansza plansza = new Plansza();
        root.setTop(new gornyPasek(plansza));
        root.setCenter(plansza);
        stage.setScene(new Scene(root, 800, 600));
        stage.setTitle("Kształty");
        stage.show();
    }
}
