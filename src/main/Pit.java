package main;

public class Pit extends NormalFloor {

	public Pit(int x, int y) {
		super(x, y);
		this.setImage('P');
	}
	
	public void interact(Player player, Direction dir){
		player.kill();
	}

}
