package main;

public class Portal {
	private Direction direction;
	private Color color;
	private SpecialWall location;
	private Portal portsTo;

	public Direction getDirection() {
		return direction;
	}
	
	public SpecialWall getLocation(){
		return location;
	}
	
	public Portal getPortsTo(){
		return portsTo;
	}
	
	public void setPortsTo(Portal p){
		portsTo = p;
	}
	
	public Portal(Direction dir, Color col, SpecialWall wall, Portal otherPortal) {
		direction = dir;
		color = col;
		location = wall;
		portsTo = otherPortal;
	}

	public Cell getWhereYouComeOut(Player player) {
		int x = 0;
		int y = 0;
		switch(direction){
		case DOWN:
			y = 0;
			break;
		case LEFT:
			x = -1;
			break;
		case RIGHT:
			x = 1;
			break;
		case UP:
			y = -1;
			break;
		}
		x += portsTo.getLocation().getX();
		y += portsTo.getLocation().getY();
		
		return player.getField().getCell(x, y);
	}
}
