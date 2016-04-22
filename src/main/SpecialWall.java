package main;

public class SpecialWall extends Wall {
	
	private Portal portal;
	
	public Portal getPortal(){
		return portal;
	}
	
	public void setPortal(Portal p){
		portal = p;
		if(p != null) {
			this.setPassable(true);
			this.setImage('T');
		}else{
			this.setPassable(false);
			this.setImage('L');
		}
	}
	
	public SpecialWall(int x, int y) {
		super(x, y);
		this.setImage('L');
		this.setPassable(false);
		portal = null;
	}
	
	public boolean interact(Player player, Direction dir){
		if(!super.interact(player, dir)){
			System.out.println("Super interact faileds");
			return false;
		}
		if(portal != null){
			System.out.println("Interacting with portal");
			if(!directionMatchesWithPortalDirection(dir)){
				System.out.println("You no enter da portal from wring direction !!");
				super.moveBackPlayer(player, dir);
				return false;
			}
			Cell target = portal.getWhereYouComeOut(player);
			if(target != null){
				System.out.println("Player should get out at "+target.getX()+","+target.getY()+" facing "+portal.getPortsTo().getDirection());
				player.moveTo(target, portal.getPortsTo().getDirection());
				return true;
			}
		}
		super.moveBackPlayer(player, dir);
		return false;
	}

	private boolean directionMatchesWithPortalDirection(Direction dir) {
		return dir == Direction.DOWN && portal.getDirection() == Direction.UP ||
			   dir == Direction.LEFT && portal.getDirection() == Direction.RIGHT ||
			   dir == Direction.RIGHT && portal.getDirection() == Direction.LEFT ||
			   dir == Direction.UP && portal.getDirection() == Direction.DOWN;
	}
}
