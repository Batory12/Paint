import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Shape;
/**
 * Obsługa zdarzenia rysowania figury
 */
public class Rysowanie implements EventHandler<MouseEvent> {
    @Override
    public void handle(MouseEvent e) {
        Plansza p  = (Plansza) e.getSource();
        if(p.rysowanaFigura()!=null) {
            if (e.getEventType()==MouseEvent.MOUSE_PRESSED){
                p.rysowanaFigura().ustawGornyRog(e.getX(), e.getY());
                p.getChildren().add((Shape)p.rysowanaFigura());
            }
            if (e.getEventType()==MouseEvent.MOUSE_DRAGGED){
                p.rysowanaFigura().ustawDolnyRog(e.getX(), e.getY());
            }
            if(e.getEventType()==MouseEvent.MOUSE_RELEASED) {
                p.przestanRysowac();
            }
        }
  
    }
}
