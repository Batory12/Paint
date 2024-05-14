import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Wczytaj implements EventHandler<ActionEvent> {
    Plansza p;
    public Wczytaj(Plansza p) {
        this.p=p;
    }
    @Override
    public void handle(ActionEvent arg0) {
        
    }
}
