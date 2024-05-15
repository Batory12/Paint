import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;

public class Zapisz implements EventHandler<ActionEvent> {
    private Plansza p;
    private ArrayList<SFigura> figury;
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
    private void zapiszStanPlanszy() {
        figury = new ArrayList<SFigura>();
        for(Node f : p.getChildren()) {
            figury.add(new SFigura((Figura)f));
        }
    }
    
}