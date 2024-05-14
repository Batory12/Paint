import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Zapisz implements EventHandler<ActionEvent> {
    Plansza p;
    public Zapisz(Plansza p) {
        this.p=p;
    }
    @Override
    public void handle(ActionEvent e) {
    }
    
}