import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;

public class EditMenu extends ContextMenu {
    public EditMenu(Figura f) {
        MenuItem m1 = new MenuItem("Wlacz edycje");
        m1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle (ActionEvent e) {
                final MenuItem m = (MenuItem)e.getSource();
                if(m.getText()=="Wlacz edycje") {
                    f.wlaczEdycje();
                    m.setText("Wylacz edycje");
                }
                else {
                    f.wylaczEdycje();
                    m.setText("Wlacz edycje");
                }

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
