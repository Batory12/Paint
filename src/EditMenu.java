import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Dialog;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputDialog;

public class EditMenu extends ContextMenu {
    public EditMenu(Figura f) {
        MenuItem m1 = new MenuItem("Włącz edycję");
        m1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle (ActionEvent e) {
                final MenuItem m = (MenuItem)e.getSource();
                if(m.getText()=="Włącz edycję") {
                    f.wlaczEdycje();
                    m.setText("Wyłącz edycję");
                }
                else {
                    f.wylaczEdycje();
                    m.setText("Włącz edycję");
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
        m3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle (ActionEvent e) {
                TextInputDialog dialog = new TextInputDialog();
                dialog.showAndWait();
                f.obroc(Integer.parseInt(dialog.getEditor().getText()));
            }
        });
        getItems().addAll(m1, m2, m3);
    }
}
