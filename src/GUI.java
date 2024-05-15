import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
/**Klasa GUI
 * Tworzy interfejs graficzny aplikacji
 * @see Plansza
 * @see gornyPasek
 */
public class GUI {
    /**
     * Konstruktor klasy GUI
     * @param stage okno aplikacji
     */
    public GUI(Stage stage) {
        BorderPane root = new BorderPane();
        Plansza plansza = new Plansza();
        root.setTop(new gornyPasek(plansza));
        root.setCenter(plansza);
        stage.setScene(new Scene(root, 800, 600));
        stage.setTitle("Paint");
        stage.show();
    }
}
