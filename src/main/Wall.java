package main;

public class Wall extends Cell implements Interactable {

	public Wall(int x, int y) {
		super(x, y);
		this.setImage('|');
	}

	private boolean isPassable = false;

	public boolean isPassable() {
		return isPassable;
	}

	public void setPassable(boolean isPassable) {
		this.isPassable = isPassable;
	}

	@Override
	public boolean interact(Player player, Direction dir) {
		if(!isPassable){
			moveBackPlayer(player, dir);
			System.out.println("Player bumped into a wall. Direction: "+dir);
			return false;
		}
		return true;
	}

	//interact with Replicator
	@Override
	public boolean interact(Replicator player, Direction dir) {
		if(!isPassable){
			moveBackPlayer(player, dir);
			System.out.println("Replicator bumped into a wall. Direction: "+dir);
			return false;
		}
		return true;
	}

	public void moveBackPlayer(Player player, Direction dir) {
		int playerX = player.getPosition().getX();
		int playerY = player.getPosition().getY();
		Cell previous;
		
		//Sets the player back to its previous place
		//Coordinates may seem to be changed, but if you
		//think about it, they should move the player up (Y-1)
		//if he tryed to move Down. This appies to all directions
		switch (dir) {
		case UP:
			previous = player.getField().getCell(playerX, playerY + 1);
			player.setPosition(previous);
			break;
		case DOWN:
			previous = player.getField().getCell(playerX, playerY - 1);
			player.setPosition(previous);
			break;
		case LEFT:
			previous = player.getField().getCell(playerX + 1, playerY);
			player.setPosition(previous);
			break;
		case RIGHT:
			previous = player.getField().getCell(playerX - 1, playerY);
			player.setPosition(previous);
			break;
		}
	}
}
