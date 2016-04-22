package main;

public class Wall extends Cell {

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
	public void interact(Player player, Direction dir) {
		int playerX = player.getPosition().getX();
		int playerY = player.getPosition().getY();
		Cell previous;
		if(!isPassable){
			switch (dir) {
			case UP:
				previous = player.getField().getCell(playerX, playerY - 1);
				player.setPosition(previous);
				break;
			case DOWN:
				previous = player.getField().getCell(playerX, playerY + 1);
				player.setPosition(previous);
				break;
			case LEFT:
				previous = player.getField().getCell(playerX - 1, playerY);
				player.setPosition(previous);
				break;
			case RIGHT:
				previous = player.getField().getCell(playerX + 1, playerY);
				player.setPosition(previous);
				break;

			}
			System.out.println("Player bumped into a wall");
		}
	}
}
