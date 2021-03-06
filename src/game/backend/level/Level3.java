package game.backend.level;

import game.backend.GameState;
import game.backend.cell.CandyFruitGeneratorCell;
import game.backend.cell.CandyGeneratorCell;
import game.backend.cell.Cell;
import game.backend.element.Wall;

public class Level3 extends Level1 {

    private final static int REQUIRED_FRUITS = 2;
    private final static int MAX_MOVES = 30;
    private CandyFruitGeneratorCell fruitGenCell;

    private GameState gameState;
    private Cell wallCell;

    @Override
    protected GameState newState() {
        gameState = new Level3State(REQUIRED_FRUITS, MAX_MOVES);
        return gameState;
    }

    public class Level3State extends GameState {
        private int requiredFruits;
        private int maxMoves;
        private final String type = "LEVEL3";

        public Level3State(int requiredFruits, int maxMoves){
            this.requiredFruits = requiredFruits;
            this.maxMoves = maxMoves;
        }

        @Override
        public String getType(){
            return type;
        }

        public boolean gameOver() { return playerWon() || getMoves() >= maxMoves; }

        public boolean playerWon() { return getFruitsAchieved() >= requiredFruits; }

        public long getMovesLeft(){
            return MAX_MOVES - getMoves();
        }

        @Override
        public int getRequiredFruits() { return requiredFruits; }
    }

    @Override
    public void setFruitGeneratorCells() {
        //corners
        g()[0][0].setAround(fruitGenCell, g()[1][0], wallCell, g()[0][1]);
        g()[0][SIZE-1].setAround(fruitGenCell, g()[1][SIZE-1], g()[0][SIZE-2], wallCell);

        //upper line cells
        for (int j = 1; j < SIZE-1; j++) {
            g()[0][j].setAround(fruitGenCell,g()[1][j],g()[0][j-1],g()[0][j+1]);
        }
    }

    @Override
    protected void fillCells() {
        fruitGenCell = new CandyFruitGeneratorCell(this, gameState);
        super.fillCells();
    }
}
