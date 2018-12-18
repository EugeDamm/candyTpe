package game.frontend;

import game.backend.CandyGame;
import game.backend.GameState;
import javafx.application.Platform;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.util.Optional;

public class AppMenu extends MenuBar {

    public AppMenu(GameApp app) {
        Menu file = new Menu("File");
        MenuItem exitMenuItem = new MenuItem("Quit Game");
        exitMenuItem.setOnAction(event -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Quit");
            alert.setHeaderText("Quit game");
            alert.setContentText("Are you sure you want to quit?");
            Optional<ButtonType> result = alert.showAndWait();
            if(result.isPresent()) {
                if (result.get() == ButtonType.OK) {
                    Platform.exit();
                }
            }
        });
        MenuItem backToMenuItem = new MenuItem("Main Menu");
        backToMenuItem.setOnAction(event -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Back");
            alert.setHeaderText("Return to main menu");
            alert.setContentText("Are you sure you want to abandon current game?");
            Optional<ButtonType> result = alert.showAndWait();
            if(result.isPresent()) {
                if (result.get() == ButtonType.OK) {
                    app.closeCurrentWindow();
                    MainMenu backToMenu = new MainMenu();
                    backToMenu.start(new Stage());
                }

            }
        });
        file.getItems().addAll(backToMenuItem, exitMenuItem);
        Menu info = new Menu("Levels");
        MenuItem level1Information = new MenuItem("Level 1");
        MenuItem level2Information = new MenuItem("Level 2");
        MenuItem level3Information = new MenuItem("Level 3");
        level1Information.setOnAction(event -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Level 1");
            alert.setHeaderText("LEVEL 1");
            alert.setContentText("Reach a score of at least 5000 points\n" +
                                "in 20 moves or less!");
            alert.showAndWait();
        });
        level2Information.setOnAction(event -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Level 2");
            alert.setHeaderText("LEVEL 2");
            alert.setContentText("Reach a score of at least 5000 points\n" +
                                "in 20 moves or less but with extra difficulty.\n" +
                                "The blue cells or 'gaps' will not allow you to\n" +
                                "make direct swapping of candy, and every valid\n" +
                                "move under them will make candy fall underneath.");
            alert.showAndWait();
        });
        level3Information.setOnAction(event -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Level 3");
            alert.setHeaderText("LEVEL 3");
            alert.setContentText("Your objective is to make 2 fruits reach the\n" +
                                "last row, within 30 moves, taking advantage of\n" +
                                "combo moves, stripped candy and even bombs.\n");
            alert.showAndWait();
        });
        info.getItems().addAll(level1Information, level2Information, level3Information);
        Menu help = new Menu("Help");
        MenuItem aboutMenuItem = new MenuItem("About");
        aboutMenuItem.setOnAction(event -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("About");
            alert.setHeaderText("Candy Crush");
            alert.setContentText("Eugenio Damm 2018.\n" +
                    "Original Implementation: Laura Zabaleta (OOP 2013).");
            alert.showAndWait();
        });
        help.getItems().add(aboutMenuItem);
        getMenus().addAll(file, info, help);
    }

}
