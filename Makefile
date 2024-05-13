#on linux
all:
	javac --module-path "/home/bartek/.local/share/javafx-sdk-21.0.3/lib/" --add-modules javafx.controls,javafx.fxml -d bin src/* && java --module-path "/home/bartek/.local/share/javafx-sdk-21.0.3/lib/" --add-modules javafx.controls,javafx.fxml -classpath bin App