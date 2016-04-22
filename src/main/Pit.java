package main;

public class Pit extends NormalFloor {

	public Pit(int x, int y) {
		super(x, y, null);
		this.setImage('P');
	}
	
	public boolean interact(Player player, Direction dir){
		player.kill();
		return true;
	}

}
