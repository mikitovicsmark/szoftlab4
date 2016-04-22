package main;

public class Door extends Wall {
	Color color;
	public Door(int x, int y, Color col) {
		super(x, y);
		this.setImage('d');
		color = col;
	}
	
	public void open(){
		this.setImage('D');
		this.setPassable(true);
	}
	
	public void close(){
		this.setImage('d');
		this.setPassable(false);
	}

}
