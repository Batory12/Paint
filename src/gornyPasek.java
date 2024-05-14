import javafx.event.ActionEvent;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.event.EventHandler;
import javafx.scene.control.*;
class gornyPasek extends MenuBar {

    public gornyPasek(Plansza r) {
        getMenus().add(new Menu("Plik"));
        getMenus().add(new Menu("Rysuj") {
            {
                getItems().add(new MenuItem("Okrag") {
                    {
                    setOnAction(new EventHandler<ActionEvent>() {
                        public void handle(ActionEvent e) {
                            r.rysuj(new Kolo());
                        }
                    });
                    }
                });
                getItems().add(new MenuItem("Prostokąt") {
                    {
                        setOnAction(new EventHandler<ActionEvent>() {
                            public void handle(ActionEvent e) {
                                r.rysuj(new Prostokat());
                            }
                        });
                    }
                });
                getItems().add(new MenuItem("Trojkat") {
                    {
                        setOnAction(new EventHandler<ActionEvent>() {
                            public void handle(ActionEvent e) {
                                r.rysuj(new Trojkat());
                            }
                        });
                    }
                });
            }
        });
        getMenus().add(new Menu("Edycja") {
            {
                getItems().add(new MenuItem("Włącz edycję"));
                getItems().add(new MenuItem("Wyłącz edycję"));
            }
        });
        getMenus().add(new Menu("Pomoc") {
            {
                getItems().add(new MenuItem("O programie"));
                getItems().add(new MenuItem("Instrukcja"));
            }
        
        });
    }
}