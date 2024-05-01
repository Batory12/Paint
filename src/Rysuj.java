import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class Rysuj {
    private Figury tryb;
    private boolean czyAktywny=false;
    private double x, y;
    public void ustawTryb(Figury tryb) {
        this.tryb = tryb;
    }
    public boolean stan() {
        return czyAktywny;
    }
    public void wlacz() {
        czyAktywny = true;
    }
    public void wylacz() {
        czyAktywny = false;
    }
    public void ustawPozycje(double x, double y) {
        this.x = x;
        this.y = y;
    }
    private Circle rysujKolo() {
        System.out.println("Rysuje kolo");
        return new Circle() {
            {
                setCenterX(x);
                setCenterY(y);
                setRadius(100);
            }
        };
    }
    private Rectangle rysujProstokat() {
        System.out.println("Rysuje prostokat");
        return new Rectangle() {
            {
                setX(x);
                setY(y);
                setWidth(100);
                setHeight(100);
            }
        };
    }
    private Trojkat rysujTrojkat() {
        System.out.println("Rysuje trojkat");
        return new Trojkat(x, y, 200);
    }
    public void rysuj(Plansza plansza) {
        if(!czyAktywny) return;
        switch (tryb) {
            case KOLO:
                plansza.getChildren().add(rysujKolo());
                break;
            case PROSTOKAT:
            plansza.getChildren().add(rysujProstokat());
                break;
            case TROJKAT:
            plansza.getChildren().add(rysujTrojkat());
        }
        wylacz();
    }
    
    
}
