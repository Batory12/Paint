import javafx.scene.control.ContextMenu;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;

public class EditMenu extends ContextMenu {
    public EditMenu(Figura f) {
        MenuItem m1 = new MenuItem("Przesuń");
        //m1.setOnAction();
        MenuItem m2 = new MenuItem("Usuń");
        MenuItem m3 = new MenuItem("Zmień rozmiar");
        MenuItem m4 = new MenuItem("Obróć");
        getItems().addAll(m1, m2, m3, m4);
    }
}
