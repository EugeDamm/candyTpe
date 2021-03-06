package game.backend.cell;

import game.backend.GameState;
import game.backend.Grid;
import game.backend.element.Candy;
import game.backend.element.CandyColor;
import game.backend.element.Element;

public class CandyGeneratorCell extends Cell {

	public CandyGeneratorCell(Grid grid) {
		super(grid);
	}
	
	@Override
	public boolean isMovable(){
		return true;
	}
	
	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public Element getContent() {
		int i = (int)(Math.random() * CandyColor.values().length);
		return new Candy(CandyColor.values()[i]);
	}
	
	@Override
	public Element getAndClearContent() {
		return getContent();
	}

	@Override
	public boolean isFruitGenerator(){
		return false;
	}

}
