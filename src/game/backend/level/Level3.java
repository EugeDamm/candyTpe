package game.backend.level;

import game.backend.GameState;
import game.backend.cell.CandyFruitGeneratorCell;
import game.backend.cell.Cell;
import game.backend.element.Wall;

public class Level3 extends Level1 {

    private static int REQUIRED_FRUITS = 2;
    private static int MAX_MOVES = 30;
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

        public Level3State(int requiredFruits, int maxMoves){
            this.requiredFruits = requiredFruits;
            this.maxMoves = maxMoves;
        }

        public boolean gameOver() { return playerWon() || getMoves() >= maxMoves; }

        public boolean playerWon() { return getFruitsAchieved() >= requiredFruits; }

        public long getMovesLeft(){
            return MAX_MOVES - getMoves();
        }
    }

    @Override
    protected void fillCells() {
        wallCell = new Cell(this);
        wallCell.setContent(new Wall());
        fruitGenCell = new CandyFruitGeneratorCell(this, gameState);

        //corners
        g()[0][0].setAround(fruitGenCell, g()[1][0], wallCell, g()[0][1]);
        g()[0][SIZE-1].setAround(fruitGenCell, g()[1][SIZE-1], g()[0][SIZE-2], wallCell);
        g()[SIZE-1][0].setAround(g()[SIZE-2][0], wallCell, wallCell, g()[SIZE-1][1]);
        g()[SIZE-1][SIZE-1].setAround(g()[SIZE-2][SIZE-1], wallCell, g()[SIZE-1][SIZE-2], wallCell);

        //upper line cells
        for (int j = 1; j < SIZE-1; j++) {
            g()[0][j].setAround(fruitGenCell,g()[1][j],g()[0][j-1],g()[0][j+1]);
        }
        //bottom line cells
        for (int j = 1; j < SIZE-1; j++) {
            g()[SIZE-1][j].setAround(g()[SIZE-2][j], wallCell, g()[SIZE-1][j-1],g()[SIZE-1][j+1]);
        }
        //left line cells
        for (int i = 1; i < SIZE-1; i++) {
            g()[i][0].setAround(g()[i-1][0],g()[i+1][0], wallCell ,g()[i][1]);
        }
        //right line cells
        for (int i = 1; i < SIZE-1; i++) {
            g()[i][SIZE-1].setAround(g()[i-1][SIZE-1],g()[i+1][SIZE-1], g()[i][SIZE-2], wallCell);
        }
        //central cells
        for (int i = 1; i < SIZE-1; i++) {
            for (int j = 1; j < SIZE-1; j++) {
                g()[i][j].setAround(g()[i-1][j],g()[i+1][j],g()[i][j-1],g()[i][j+1]);
            }
        }
    }
}
