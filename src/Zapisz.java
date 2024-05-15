import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
/**
 * Klasa obsługująca zapisywanie stanu planszy do pliku
 */
public class Zapisz implements EventHandler<ActionEvent> {
    /**
     * Plansza do zapisania
     */
    private Plansza p;
    /**
     * Lista własności figur do zapisania
     * @see SFigura
     */
    private ArrayList<SFigura> figury;
    /**
     * Konstruktor klasy Zapisz
     * @param p plansza do zapisania
     */
    public Zapisz(Plansza p) {
        this.p=p;
    }
    @Override
    public void handle(ActionEvent e) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("plansza.ser"));
            zapiszStanPlanszy();
            out.writeObject(figury);
            out.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    /**
     * Metoda zapiszStanPlanszy
     * Zapisuje stan planszy do listy figury
     * @see SFigura
     * @see Figura
     */
    private void zapiszStanPlanszy() {
        figury = new ArrayList<SFigura>();
        for(Node f : p.getChildren()) {
            figury.add(new SFigura((Figura)f));
        }
    }
    
}