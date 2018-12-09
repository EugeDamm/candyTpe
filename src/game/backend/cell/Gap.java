package game.backend.cell;

import game.backend.Grid;
import game.backend.element.GapElement;

public class Gap extends Cell{

    public Gap(Grid grid) {
        super(grid);
        this.content = new GapElement();
    }

}
