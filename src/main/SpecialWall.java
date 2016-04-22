package main;

public class SpecialWall extends Wall {
	
	private Portal portal;
	
	public Portal getPortal(){
		return portal;
	}
	
	public void setPortal(Portal p){
		portal = p;
		if(p != null) {
			this.setImage('T');
		}else{
			this.setImage('L');
		}
	}
	
	public SpecialWall(int x, int y) {
		super(x, y);
		this.setImage('L');
		portal = null;
	}
}
