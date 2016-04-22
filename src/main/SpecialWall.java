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
		portal = null;
	}
	
	public boolean interact(Player player, Direction dir){
		if(portal != null){
			System.out.println("Interacting with portal");
			player.moveTo(portal.getWhereYouComeOut(player), portal.getPortsTo().getDirection());
		}
		
		return true;
	}
}
