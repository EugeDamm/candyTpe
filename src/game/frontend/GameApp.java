package game.frontend;

import game.backend.CandyGame;
import game.backend.level.Level1;
import game.backend.level.Level2;
import game.backend.level.Level3;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.event.ActionEvent;

public class GameApp extends Application {

	private Class<?> chosenClass;
    private Stage primaryStage;

	public GameApp(Level chosenLevel){
	    chosenClass = chosenLevel.getClazz();
	}

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		System.out.println(chosenClass);
		this.primaryStage = primaryStage;
		CandyGame game = new CandyGame(chosenClass);
		CandyFrame frame = new CandyFrame(this, game);
		Scene scene = new Scene(frame);
		primaryStage.setResizable(false);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

    public void closeCurrentWindow(){
        this.primaryStage.close();
    }
}

