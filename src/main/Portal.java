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
	
	public Color getColor(){
		return color;
	}
	
	public Portal getPortsTo(){
		return portsTo;
	}
	
	public void setPortsTo(Portal p){
		portsTo = p;
	}
	
	public Portal(Direction dir, Color col, SpecialWall wall) {
		direction = dir;
		color = col;
		location = wall;
		System.out.println("Portal created at "+wall.getX()+","+wall.getY()+" facing "+dir);
	}

	public Cell getWhereYouComeOut(Player player) {
		int x = 0;
		int y = 0;
		switch(portsTo.getDirection()){
		case DOWN:
			y = 1;
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
		if(portsTo != null){
			x += portsTo.getLocation().getX();
			y += portsTo.getLocation().getY();

			System.out.println("Should go to "+x+","+y);
			System.out.println("Becouse direction is "+portsTo.getDirection());
			return player.getField().getCell(x, y);
		}
		System.out.println("No target found");
		return null;
	}
}
