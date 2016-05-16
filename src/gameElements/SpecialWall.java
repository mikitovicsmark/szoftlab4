package gameElements;

import enums.Direction;

public class SpecialWall extends Wall {

	private Portal portal;

	public Portal getPortal() {
		return portal;
	}

	public void setPortal(Portal p) {
		portal = p;
		if (p != null) {
			this.setPassable(true);
			this.setImage('T');
		} else {
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

	public boolean interact(Player player, Direction dir) {
		if (!super.interact(player, dir)) {
			return false;
		}
		if (portal != null && portal.getPortsTo() != null) {
			if (!directionMatchesWithPortalDirection(dir)) {
				super.moveBackPlayer(player, dir);
				return false;
			}
			Cell target = portal.getWhereYouComeOut(player);
			if (target != null) {
				player.moveTo(target, portal.getPortsTo().getDirection());
				return true;
			}
		}
		super.moveBackPlayer(player, dir);
		return false;
	}

	// interact with Replicator
	public boolean interact(Replicator player, Direction dir) {
		if (!super.interact(player, dir)) {
			return false;
		}
		if (portal != null) {
			if (!directionMatchesWithPortalDirection(dir)) {
				super.moveBackPlayer(player, dir);
				return false;
			}
			Cell target = portal.getWhereYouComeOut(player);
			if (target != null) {
				player.moveTo(target, portal.getPortsTo().getDirection());
				return true;
			}
		}
		super.moveBackPlayer(player, dir);
		return false;
	}

	private boolean directionMatchesWithPortalDirection(Direction dir) {
		return dir == Direction.DOWN && portal.getDirection() == Direction.UP
				|| dir == Direction.LEFT && portal.getDirection() == Direction.RIGHT
				|| dir == Direction.RIGHT && portal.getDirection() == Direction.LEFT
				|| dir == Direction.UP && portal.getDirection() == Direction.DOWN;
	}
	public boolean hasPortal(){
		return portal!=null;
	}
}
