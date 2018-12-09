package game.backend.element;

public enum FruitType {

    CHERRY(200),
    NUT(150);

    private int score;

    FruitType(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

}
