import game.backend.CandyGame;
import game.backend.cell.Cell;
import game.backend.cell.Gap;
import game.backend.level.Level2;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Level2Test {

    private CandyGame game;

    @Before
    public void setGame() {
        game = new CandyGame(Level2.class);
        game.initGame();
    }

    @Test
    public void createLevel() {
        Assert.assertNotNull(game);
    }

    @Test
    public void getState() {
        Assert.assertNotNull(game.getState());
    }

    @Test
    public void falseMove() {
        Assert.assertFalse(game.tryMove(0,0,3,3));
    }

    @Test
    public void isGap() {
        Cell gap = game.get(4,4);

        Assert.assertTrue(gap instanceof Gap);
    }
}