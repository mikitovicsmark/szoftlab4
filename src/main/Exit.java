package main;

public class Exit extends Wall {

	public Exit(int x, int y) {
		super(x, y);
		this.setImage('e');
	}
	
	public boolean interact(Player player, Direction dir){
		if(super.interact(player, dir)){
			System.out.println("Player exited from map");
			player.kill();
			return true;
		}
		return false;
	}
	
	public void openExit(){
		this.setImage('E');
		this.setPassable(true);
	}

}
