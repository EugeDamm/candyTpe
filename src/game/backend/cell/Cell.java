package game.backend.cell;

import game.backend.GameState;
import game.backend.Grid;
import game.backend.element.*;
import game.backend.move.Direction;

import javax.swing.*;

public class Cell {
	
	private Grid grid;
	protected Cell[] around = new Cell[Direction.values().length];
	protected Element content;

    public Cell(Grid grid) {
		this.grid = grid;
		this.content = new Nothing();
	}

	@Override
	public String toString(){
		System.out.print(content.getKey());
		return "";
	}

	public Cell[] getAround(){
		return around;
	}

	public void setAround(Cell up, Cell down, Cell left, Cell right) {
		this.around[Direction.UP.ordinal()] = up;
		this.around[Direction.DOWN.ordinal()] = down;
		this.around[Direction.LEFT.ordinal()] = left;
		this.around[Direction.RIGHT.ordinal()] = right;
	}

	public boolean hasFloor() {
		return !around[Direction.DOWN.ordinal()].isEmpty();
	}
	
	public boolean isMovable(){
		return content.isMovable();
	}
	
	public boolean isEmpty() {
		return !content.isSolid();
	}

	public Element getContent() {
		return content;
	}

	public Element getContentWithoutFruit() { return getContent(); }
	
	public void clearContent() {
        if (content.isMovable() && content.isExplodable()) {
            clearCell();
        }
    }

	private void clearCell() {
        Direction[] explosionCascade = content.explode();
        grid.cellExplosion(content);
        this.content = new Nothing();
        if (explosionCascade != null) {
            expandExplosion(explosionCascade);
        }
        this.content = new Nothing();
    }

    public void clearFruit() {
        clearCell();
    }
	
	private void expandExplosion(Direction[] explosion) {
		for(Direction d: explosion) {
			this.around[d.ordinal()].explode(d);
		}
	}
	
	private void explode(Direction d) {
		clearContent();
		if (this.around[d.ordinal()] != null)
			this.around[d.ordinal()].explode(d);
	}
	
	public Element getAndClearContent() {
		if (content.isMovable()) {
			Element ret = content;
			this.content = new Nothing();
			return ret;
		}
		return null;
	}

	public boolean isFruitGenerator(){
		return false;
	}

	/*public boolean fallUpperContentWithCondition(GameState state){
		Cell up = around[Direction.UP.ordinal()];
		if(state.getFruitsPresent() == 0){
			if(this.isEmpty() && !up.isEmpty() && up.isMovable()){
				int i = (int)(Math.random());
				if(i % 2 == 0)
					this.content = new Cherry();
				else
					this.content = new Nut();
				grid.wasUpdated();
				if(this.hasFloor()) {
					grid.tryRemove(this);
					return true;
				} else {
					Cell down = around[Direction.DOWN.ordinal()];
					return down.fallUpperContent(state);
				}
			}
		}
		return fallUpperContent(state);
	}*/

	public boolean fallUpperContent(GameState state) {
		Cell up = around[Direction.UP.ordinal()];
		//TODO state should know that info by itself
		if(state.getType().equals("LEVEL2")) {
			while (!up.getContent().getKey().equals("CANDY")) {
				up = up.around[Direction.UP.ordinal()];
			}
		}
		if (this.isEmpty() && !up.isEmpty() && up.isMovable()) {
			this.content = up.getAndClearContent();
			grid.wasUpdated();
			if(this.hasFloor()) {
				grid.tryRemove(this);
				return true;
			} else {
				Cell down = around[Direction.DOWN.ordinal()];
				return down.fallUpperContent(state);
			}
		} 
		return false;
	}

	public void setContent(Element content) {
		this.content = content;
	}

}
