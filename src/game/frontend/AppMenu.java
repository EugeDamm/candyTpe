package game.frontend;

import javafx.application.Platform;
import javafx.scene.control.*;

import java.util.Optional;

public class AppMenu extends MenuBar {

    public AppMenu() {
        Menu file = new Menu("Archivo");
        MenuItem exitMenuItem = new MenuItem("Salir");
        exitMenuItem.setOnAction(event -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Salir");
            alert.setHeaderText("Salir de la aplicación");
            alert.setContentText("¿Está seguro que desea salir de la aplicación?");
            Optional<ButtonType> result = alert.showAndWait();
            if(result.isPresent()) {
                if (result.get() == ButtonType.OK) {
                    Platform.exit();
                }
            }
        });
        file.getItems().add(exitMenuItem);
        Menu info = new Menu("Niveles");
        MenuItem level1Information = new MenuItem("Nivel 1");
        MenuItem level2Information = new MenuItem("Nivel 2");
        MenuItem level3Information = new MenuItem("Nivel 3");
        level1Information.setOnAction(event -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Nivel 1");
            alert.setHeaderText("NIVEL 1");
            alert.setContentText("Alcanza una puntuación de por lo menos 5000 puntos\n" +
                                "en 20 movimientos o menos!");
            alert.showAndWait();
        });
        level2Information.setOnAction(event -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Nivel 2");
            alert.setHeaderText("NIVEL 2");
            alert.setContentText("Alcanza una puntuación de por lo menos 5000 puntos\n" +
                                "en 20 movimientos o menos con dificultad.\n" +
                                "bloques azules o 'gaps' no te permitirán hacer\n" +
                                "intercambios directos, y las caídas de caramelos" +
                                "ocurrirán por detrás de los mismos!");
            alert.showAndWait();
        });
        level3Information.setOnAction(event -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Nivel 3");
            alert.setHeaderText("NIVEL 3");
            alert.setContentText("Debes lograr que 2 frutas alcancen las filas\n" +
                                "finales en 30 movimientos o menos, haciendo combos\n" +
                                "y combinaciones con los caramelos adyacentes o cercanos!\n");
            alert.showAndWait();
        });
        info.getItems().addAll(level1Information, level2Information, level3Information);
        Menu help = new Menu("Ayuda");
        MenuItem aboutMenuItem = new MenuItem("Acerca De");
        aboutMenuItem.setOnAction(event -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Acerca De");
            alert.setHeaderText("Candy TPE");
            alert.setContentText("Cátedra POO 2018.\n" +
                    "Implementación Original: Laura Zabaleta (POO 2013).");
            alert.showAndWait();
        });
        help.getItems().add(aboutMenuItem);
        getMenus().addAll(file, info, help);
    }

}
