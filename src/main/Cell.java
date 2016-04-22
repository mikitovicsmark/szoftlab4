package main;

public class Cell implements Interactable {
	private int x;
	private int y;
	private char image;

	public char getImage() {
		return image;
	}

	public void setImage(char image) {
		this.image = image;
	}

	public int getX() {
		return x;
	}

	public void setCoordinates(int x, int y) {
		this.y = y;
		this.x = x;
	}

	public int getY() {
		return y;
	}
	
	public Cell(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public boolean interact(Player player, Direction dir) {
		System.out.println("Player stepped on " + x + " " + y);
		return true;
	}

}
