package gameElements;

import enums.Direction;
import main.Game;
import main.GameField;

public class Exit extends Wall {

	public Exit(int x, int y) {
		super(x, y);
		this.setImage('e');
	}
	
	public boolean interact(Player player, Direction dir){
		if(super.interact(player, dir)){
			player.kill();
		    if(player.getField().Getlevel()==30){
		    	Game.exit=true;	
		    }
			player.getField().loadNextLevel();
			return true;
		}
		return false;
	}

	//interact with Replicator
	public boolean interact(Replicator player, Direction dir){
		return false;
	}
	
	public void openExit(){
		this.setImage('E');
		this.setPassable(true);
	}

}
