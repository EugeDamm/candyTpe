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

	public GameApp(String selectedOption){
		System.out.println(selectedOption);
		
		if(selectedOption.equals("NIVEL 1")){
			chosenClass = Level1.class;
		} else if(selectedOption.equals("NIVEL 2")) {
			chosenClass = Level2.class;
		} else {
			chosenClass = Level3.class;
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		CandyGame game = new CandyGame(chosenClass);
		CandyFrame frame = new CandyFrame(game);
		Scene scene = new Scene(frame);
		primaryStage.setResizable(false);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
