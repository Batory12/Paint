import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
/**
 * Klasa obsługująca wczytywanie stanu planszy z pliku
 * @see Zapisz
 */
public class Wczytaj implements EventHandler<ActionEvent> {
    /**
     * Plansza do której wczytujemy stan
     */
    Plansza p;
    /**
     * Lista figur do wczytania
     */
    ArrayList<SFigura> figury;
    /**
     * Konstruktor klasy Wczytaj
     * @param p plansza do której wczytujemy stan
     */
    public Wczytaj(Plansza p) {
        this.p=p;
    }
    @Override
    public void handle(ActionEvent arg0) {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("plansza.ser"));
            p.getChildren().clear();
            figury = (ArrayList<SFigura>)in.readObject();
            for(SFigura f : figury) {
                p.getChildren().add(stworzFigure(f));
            }
            in.close();

            
        } catch (Exception e) {
            Alert a = new Alert(AlertType.ERROR, "Błąd wczytywania");
            a.show();
        }
    }
    /**
     * Metoda stworzFigure
     * Tworzy figurę na podstawie obiektu klasy SFigura
     * @param f obiekt klasy SFigura
     * @return figura
     * @see SFigura
     * @see Figura
     */
    private Shape stworzFigure(SFigura f) {
        switch (f.typ) {
            case 'K':
                return new Kolo(f.x, f.y, f.r, Color.color(f.red, f.green, f.blue), f.kat);
            case 'P':
                return new Prostokat(f.x, f.y, f.w, f.h, Color.color(f.red, f.green, f.blue), f.kat);
            case 'T':
                return new Trojkat(f.x, f.y, f.botX, f.botY, Color.color(f.red, f.green, f.blue), f.kat);
        }
        return null;
    }
}
