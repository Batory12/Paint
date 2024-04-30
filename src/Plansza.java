import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class Plansza extends Pane {
    public Plansza(Rysuj r) {
        setPrefSize(600,600);
        setOnMousePressed(e -> {
            r.zmienStan();
        });
    }
}
