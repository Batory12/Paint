import javafx.event.EventHandler;
import javafx.scene.input.ScrollEvent;
/**
 * Obsługa zdarzenia skalowania figury
 */
public class Skalowanie implements EventHandler<ScrollEvent>{
    /**
     * Aktualnie skalowana figura
     */
    private Figura f;
    @Override
    public void handle(ScrollEvent e) {
        f = (Figura)e.getSource();
        if(f.zawiera(e.getX(), e.getY())) {
            f.skaluj(e.getDeltaY());
        }
    }
    
}
