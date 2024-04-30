import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
public class GUI {
    private class gornyPasek extends MenuBar {
        public gornyPasek() {
            getMenus().add(new Menu("Plik"));
            getMenus().add(new Menu("Rysuj") {
                {
                    getItems().add(new MenuItem("Okrag"));
                    getItems().add(new MenuItem("Prostokąt"));
                    getItems().add(new MenuItem("Trojkat"));
                }
            });
            getMenus().add(new Menu("Pomoc") {
                {
                    getItems().add(new MenuItem("O programie"));
                    getItems().add(new MenuItem("Instrukcja"));
                }
            
            });
        }
    }
    public GUI(Stage stage) {
        Rysuj r = new Rysuj();
        BorderPane root = new BorderPane();
        root.setTop(new gornyPasek());
        Plansza plansza = new Plansza(r);
        root.setCenter(plansza);
        stage.setScene(new Scene(root, 800, 600));
        stage.show();
    }
}
