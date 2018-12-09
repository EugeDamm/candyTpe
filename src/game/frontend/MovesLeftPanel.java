package game.frontend;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class MovesLeftPanel extends BorderPane {

    private Label movesLabel;
    private long movesLeft;
    private final String message = "Moves left: ";



    public MovesLeftPanel(long movesLeft){
        this.movesLeft = movesLeft;
        setStyle("-fx-background-color: #5490ff");
        movesLabel = new Label(message + String.valueOf(movesLeft));
        movesLabel.setAlignment(Pos.CENTER);
        setCenter(movesLabel);
    }

    public void updateMoves(){
        movesLabel.setText(String.valueOf(message + --movesLeft));
    }
}
