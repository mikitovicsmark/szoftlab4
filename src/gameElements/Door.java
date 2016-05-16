package gameElements;

import enums.Color;

public class Door extends Wall {
	Color color;
	int ID;

	public Door(int x, int y, Color col, int nwid) {
		super(x, y);
		this.setImage('d');
		color = col;
		ID=nwid;
	}
	
	public void open(){
		this.setImage('D');
		this.setPassable(true);
	}
	
	public void close(){
		this.setImage('d');
		this.setPassable(false);
	}
	public int getID(){
		return ID;
	}
	public Color getColor(){
		return color;
	}
}
