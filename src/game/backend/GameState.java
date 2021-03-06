package game.backend;

public abstract class GameState {
	
	private long score = 0;
	private int moves = 0;
	private int fruitsPresent = 0;
	private int fruitsAchieved = 0;
	private boolean frozen = false;

	public void addScore(long value) {
		this.score = this.score + value;
	}

	public long getScore(){
		return score;
	}
	
	public void addMove() {
		moves++;
	}
	
	public int getMoves() {
		return moves;
	}

	public abstract String getType();

	public void addFruitPresent() { this.fruitsPresent++; }

	public void addFruitsAchieved() { this.fruitsAchieved++;}

	public int getFruitsPresent() { return fruitsPresent; }

	public void removeFruitPresent() { this.fruitsPresent--; }

	public int getFruitsAchieved() { return fruitsAchieved; }
	
	public abstract boolean gameOver();
	
	public abstract boolean playerWon();

	public abstract long getMovesLeft();

	public int getRequiredFruits() { return 0; }

	public void freezeGame(){
		frozen = true;
	}

	public boolean isFrozen(){
		return frozen;
	}

}
