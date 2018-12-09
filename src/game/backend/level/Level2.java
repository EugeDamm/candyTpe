package game.backend.level;

import game.backend.FigureDetector;
import game.backend.GameState;
import game.backend.Grid;
import game.backend.cell.CandyGeneratorCell;
import game.backend.cell.Cell;
import game.backend.cell.Gap;
import game.backend.element.*;
import game.backend.move.MoveMaker;

import java.awt.*;

public class Level2 extends Level1 {
    //GAPS
    private final static int REQUIRED_SCORE = 3000;
    private final static int MAX_MOVES = 20;

    private Cell gapCell;
    private Cell wallCell;
    private Cell candyGenCell;

    @Override
    public void initialize(){
        moveMaker = new MoveMaker(this);
        figureDetector = new FigureDetector(this);
        for(int i = 0 ; i < SIZE ; i++){
            for(int j = 0 ; j < SIZE ; j++){
                if(i == 3 || i == 4 || i == 5)
                    g[i][j] = new Gap(this);
                else
                    g[i][j] = new Cell(this);
                gMap.put(g[i][j], new Point(i,j));
            }
        }
        fillCells();
        //printGrid();
        fallElements();
    }

    @Override
    protected GameState newState() {
        return new Level2State(REQUIRED_SCORE, MAX_MOVES);
    }

    //TODO quizas hay que overridearlo para que los espacios no se toquen
    @Override
    public boolean tryMove(int i1, int j1, int i2, int j2){
        boolean ret;
        if(ret = super.tryMove(i1, j1, i2, j2))
            state().addMove();
        return ret;
    }

    private class Level2State extends GameState {
        private long requiredScore;
        private long maxMoves;
        private final String type = "LEVEL2";

        public Level2State(long requiredScore, long maxMoves) {
            this.requiredScore = requiredScore;
            this.maxMoves = maxMoves;
        }

        @Override
        public String getType(){
            return type;
        }

        public boolean gameOver() {
            return playerWon() || getMoves() >= maxMoves;
        }

        public boolean playerWon() {
            return getScore() > requiredScore;
        }

        public long getMovesLeft() {
            return maxMoves - getMoves();
        }
    }
}
