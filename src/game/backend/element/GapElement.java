package game.backend.element;

public class GapElement extends Element {

    @Override
    public boolean isMovable(){
        return false;
    }

    @Override
    public String getKey(){
        return "GAPELEMENT";
    }

    @Override
    public boolean isExplodable() { return false; }
}
