import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

public class Wczytaj implements EventHandler<ActionEvent> {
    Plansza p;
    ArrayList<SFigura> figury;
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

            
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    private Shape stworzFigure(SFigura f) {
        switch (f.typ) {
            case 'K':
                return new Kolo(f.x, f.y, f.r, Color.color(f.red, f.green, f.blue));
            case 'P':
                return new Prostokat(f.x, f.y, f.w, f.h, Color.color(f.red, f.green, f.blue));
            case 'T':
                return new Trojkat(f.x, f.y, f.botX, f.botY, Color.color(f.red, f.green, f.blue));
        }
        return null;
    }
}
