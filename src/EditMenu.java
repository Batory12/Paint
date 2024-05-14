import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;

public class EditMenu extends ContextMenu {
    public EditMenu(Figura f) {
        MenuItem m1 = new MenuItem("Edytuj");
        m1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle (ActionEvent e) {
                
            }
        });
        MenuItem m2 = new MenuItem("Usuń");
        m2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle (ActionEvent e) {
                final Plansza p = (Plansza)((Node)f).getParent();
                p.getChildren().remove(f);
            }
        });
        MenuItem m3 = new MenuItem("Obróć");
        getItems().addAll(m1, m2, m3);
    }
}
