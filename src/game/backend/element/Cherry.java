package game.backend.element;

public class Cherry extends Fruit {

    private FruitType fruitType = FruitType.CHERRY;

    @Override
    public String getKey() {
        return "CHERRY";
    }

}
