package game.backend.element;

public abstract class Fruit extends Element {

    @Override
    public boolean isFruit(){
        return true;
    }

    @Override
    public boolean isMovable() {
        return true;
    }

}
