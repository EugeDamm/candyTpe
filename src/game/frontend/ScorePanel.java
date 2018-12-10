package game.frontend;

import game.backend.CandyGame;
import game.backend.level.Level3;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class ScorePanel extends BorderPane {

	private Label scoreLabel;
	// private CandyGame game;

	public ScorePanel(CandyGame game) {
		setStyle("-fx-background-color: #5490ff");
        scoreLabel = new Label("0");
		scoreLabel.setAlignment(Pos.CENTER);
		scoreLabel.setStyle("-fx-font-size: 24");
		setCenter(scoreLabel);
	}
	
	public void updateScore(String text) {
		scoreLabel.setText(text);
	}

}