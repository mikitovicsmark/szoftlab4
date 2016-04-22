package main;

public class Portal {
	private Direction direction;
	private Color color;
	private Cell location;
	private Portal portsTo;
	
	public Cell getLocation(){
		return location;
	}
	
	public Portal getPortsTo(){
		return portsTo;
	}
	
	public void setPortsTo(Portal p){
		portsTo = p;
	}
	
	public Portal(Direction dir, Color col, Cell cell, Portal otherPortal) {
		direction = dir;
		color = col;
		location = cell;
		portsTo = otherPortal;
	}

}
