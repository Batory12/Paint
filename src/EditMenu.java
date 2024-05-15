import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.CustomMenuItem;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextInputDialog;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

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
                dialog.getEditor().setText("0");
                f.obroc(Integer.parseInt(dialog.getEditor().getText()));
            }
        });
        ColorPicker cp = new ColorPicker((Color)(((Shape)f).getFill()));
        CustomMenuItem m4 = new CustomMenuItem(cp);
        m4.setHideOnClick(false);
        getItems().addAll(m1, m2, m3, m4);
        m4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle (ActionEvent e) {
                autoHideProperty().set(false);
                ((Shape)f).setFill(cp.getValue());
            }
        });
        cp.setOnHidden(new EventHandler<Event>() {
            @Override
            public void handle (Event e) {
                autoHideProperty().set(true);
            }
        });

    }
}
