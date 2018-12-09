package game.backend.cell;

import game.backend.GameState;
import game.backend.Grid;
import game.backend.element.*;

public class CandyFruitGeneratorCell extends CandyGeneratorCell {

    private GameState gameState;

    public CandyFruitGeneratorCell(Grid grid, GameState gameState) {
        super(grid);
        this.gameState = gameState;
    }

    @Override
    public boolean isFruitGenerator(){
        return true;
    }

    @Override
    public Element getContent() {
        //System.out.println("Fruits Present = " + gameState.getFruitsPresent());
        if (gameState.getFruitsPresent() == 0) {
            int i = (int)(Math.random() * (CandyColor.values().length + 1));
            if (i < CandyColor.values().length) {
                return new Candy(CandyColor.values()[i]); }
            gameState.addFruitPresent();
            i = (int)(Math.random() * CandyColor.values().length);
            if(i % 2 == 0)
                return new Cherry();
            return new Nut();
        }
        return super.getContent();
    }
}
