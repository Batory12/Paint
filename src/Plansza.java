import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

public class Plansza extends Pane {
    public Plansza(Rysuj r) {
        setMaxSize(800, 600);
        setOnMouseClicked(e -> {
            System.out.println("Kliknieto plansze");
            r.ustawPozycje(e.getX(), e.getY());
            r.rysuj(this);
        });
    };
}
