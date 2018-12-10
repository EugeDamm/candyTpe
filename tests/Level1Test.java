import game.backend.CandyGame;
import game.backend.level.Level1;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Level1Test {

    private CandyGame game;

    @Before
    public void setGame() {
        game = new CandyGame(Level1.class);
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
}
