import javafx.event.EventHandler;
import javafx.scene.input.ScrollEvent;

public class Skalowanie implements EventHandler<ScrollEvent>{
    Figura f;
    @Override
    public void handle(ScrollEvent e) {
        f = (Figura)e.getSource();
        if(f.zawiera(e.getX(), e.getY())) {
            f.skaluj(e.getDeltaY());
        }
    }
    
}
