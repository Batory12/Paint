import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
public class GUI {
    private class gornyPasek extends MenuBar {

        public gornyPasek(Rysuj r) {
            getMenus().add(new Menu("Plik"));
            getMenus().add(new Menu("Rysuj") {
                {
                    getItems().add(new MenuItem("Okrag") {
                        {
                        setOnAction(new EventHandler<ActionEvent>() {
                            public void handle(ActionEvent e) {
                                r.ustawTryb(Figury.KOLO);
                                r.wlacz();
                                System.out.println("Kliknieto okrag");
                            }
                        });
                        }
                    });
                    getItems().add(new MenuItem("Prostokąt") {
                        {
                            setOnAction(new EventHandler<ActionEvent>() {
                                public void handle(ActionEvent e) {
                                    r.ustawTryb(Figury.PROSTOKAT);
                                    r.wlacz();
                                    System.out.println("Kliknieto prostokat");
                                }
                            });
                        }
                    });
                    getItems().add(new MenuItem("Trojkat") {
                        {
                            setOnAction(new EventHandler<ActionEvent>() {
                                public void handle(ActionEvent e) {
                                    r.ustawTryb(Figury.TROJKAT);
                                    r.wlacz();
                                    System.out.println("Kliknieto trojkat");
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
    public GUI(Stage stage) {
        Rysuj r = new Rysuj();
        BorderPane root = new BorderPane();
        root.setTop(new gornyPasek(r));
        Plansza plansza = new Plansza(r);
        root.setCenter(plansza);
        stage.setScene(new Scene(root, 800, 600));
        stage.setTitle("Kształty");
        stage.show();
    }
}
