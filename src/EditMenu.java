import javafx.scene.control.ContextMenu;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;

public class EditMenu extends ContextMenu {
    public EditMenu(Rysuj r) {
        MenuItem m1 = new MenuItem("Przesuń");
        MenuItem m2 = new MenuItem("Usun");
        MenuItem m3 = new MenuItem("Zmień kolor");
        MenuItem m4 = new MenuItem("Zmień rozmiar");
        MenuItem m5 = new MenuItem("Obróć");
        getItems().addAll(m1, m2);
    }
}
