package main;

public class Player implements Moving {

	public Player(Cell position) {
		this.position = position;
		this.image = 'O';
	}

	private GameField field;

	public GameField getField() {
		return field;
	}

	public void setField(GameField field) {
		this.field = field;
	}

	private Cell position;
	private char image;
	private Box box;

	public Box getBox() {
		return box;
	}
	
	public void setBox(Box b) {
		box = b;
	}
	
	public char getImage() {
		return image;
	}

	public void setImage(char image) {
		this.image = image;
	}

	public Cell getPosition() {
		return position;
	}

	public void setPosition(Cell cell) {
		this.position = cell;
	}
	
	public void kill(){
		field.Initialize(field.getLevel());
	}

	@Override
	public void moveTo(Cell cell, Direction dir) {
		this.setPosition(cell);
		cell.interact(this, dir);
	}

	public void pickUpZpm() {
		field.zpmPickedUp();
		
	}
}
