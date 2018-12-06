package game.backend.cell;

import game.backend.Grid;
import game.backend.element.Element;
import game.backend.element.Fruit;
import game.backend.element.FruitType;

public class FruitGeneratorCell extends Cell {

    public FruitGeneratorCell(Grid grid) {
        super(grid);
    }

    @Override
    public boolean isMovable(){
    	return true;
    }

    @Override
    public boolean isEmpty(){
    	return false;
    }

    @Override
    public Element getContent(){
    	int i = (int)(Math.random() * FruitType.values().length);
    	return new Fruit(FruitType.values()[i]);
    }

    @Override
    public Element getAndClearContent(){
    	return getContent();
    }

    @Override
    public boolean fallUpperContent(){
    	throw new IllegalStateException();
    }

    @Override
    public void setContent(Element content){
    	throw new IllegalStateException();
    }

    @Override
    public boolean equals(Object object){
    	return false;
    }

}
