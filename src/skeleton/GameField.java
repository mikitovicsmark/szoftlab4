package skeleton;

public class GameField {
	private int _height;
	private int _width;
	private Cell[][] cellArray;
	private int _timeLeft;
	private boolean _isPaused;
	public Move _unnamed_Move_;
	public Player _unnamed_Player_;
	public Timer _timer;
	public Cell _unnamed_Cell_;

	public Cell getCell(int aX, int aY) {
		throw new UnsupportedOperationException();
	}

	public void setCell(int aX, int aY, Cell aC) {
		throw new UnsupportedOperationException();
	}

	public void decreaseTime() {
		throw new UnsupportedOperationException();
	}

	public void restart() {
		throw new UnsupportedOperationException();
	}

	public int GameOver() {
		throw new UnsupportedOperationException();
	}

	public void Initialize() {
		throw new UnsupportedOperationException();
	}
}
