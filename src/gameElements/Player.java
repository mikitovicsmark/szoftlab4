package gameElements;

import enums.Color;
import enums.Direction;
import interfaces.Moving;
import main.GameField;

public class Player implements Moving {
	private Cell position;
	private char image;
	private Box box;
	private GameField field;
	private int zpmCount;
	private Portal firstPortal;
	private Portal secondPortal;
	private Direction dir;
	private boolean wasOnSwitch; // Needed to know if the player just stepped
									// off a switch

	public GameField getField() {
		return field;
	}

	public void setField(GameField field) {
		this.field = field;
	}

	public void setFirstPortal(Portal firstp) {// for testing purposes
		firstPortal = firstp;
	}

	public int getZpmCount() {
		return zpmCount;
	}

	public void setSecondPortal(Portal secp) {// for testing purposes
		secondPortal = secp;
	}

	public Portal getFirstPortal() {
		return this.firstPortal;
	}

	public Portal getSecondPortal() {
		return this.secondPortal;
	}

	public Box getBox() {
		return box;
	}

	public void setBox(Box b) {
		box = b;
	}

	public char getImage() {
		return image;
	}

	public void setImage(char image) {
		this.image = image;
	}

	public Cell getPosition() {
		return position;
	}

	public void setPosition(Cell cell) {
		this.position = cell;
	}

	public Player(Cell position) {
		this.position = position;
		this.image = 'O';
		zpmCount = 0;
		dir = Direction.RIGHT;
		wasOnSwitch = false;
		box = null;
	}

	public Player() {
		this.image = 'O';
		this.zpmCount = 0;
		this.dir = Direction.RIGHT;
	}

	public void shootFirstPortal(Color col) {
		Portal tmpPortal = shootPortal(dir, col);
		if (tmpPortal != null) {
			if (firstPortal != null) {
				firstPortal.getLocation().setPortal(null);
			}
			firstPortal = tmpPortal;
			if (secondPortal != null) {
				firstPortal.setPortsTo(secondPortal);
				secondPortal.setPortsTo(firstPortal);
			}
		}
	}

	public void shootSecondPortal(Color col) {
		Portal tmpPortal = shootPortal(dir, col);
		if (tmpPortal != null) {
			if (secondPortal != null) {
				secondPortal.getLocation().setPortal(null);
			}
			secondPortal = tmpPortal;
			if (firstPortal != null) {
				firstPortal.setPortsTo(secondPortal);
				secondPortal.setPortsTo(firstPortal);
			}
		}
	}

	private Portal shootPortal(Direction dir, Color col) {
		Cell cell = position;
		boolean canGoFurther = true;
		boolean hitReplicator = false;
		while (canGoFurther) {
			switch (dir) {
			case DOWN:
				if (cell.getY() + 1 >= field.getHeight()) {
					return null;
				}
				cell = field.getCell(cell.getX(), cell.getY() + 1);
				break;
			case LEFT:
				if (cell.getX() - 1 < 0) {
					return null;
				}
				cell = field.getCell(cell.getX() - 1, cell.getY());
				break;
			case RIGHT:
				if (cell.getX() + 1 > field.getWidth()) {
					return null;
				}
				cell = field.getCell(cell.getX() + 1, cell.getY());
				break;
			case UP:
				if (cell.getY() - 1 < 0) {
					return null;
				}
				cell = field.getCell(cell.getX(), cell.getY() - 1);
				break;
			}
			if (field.getReplicator() != null) {
				if (cell.getX() == field.getReplicator().getPosition().getX()
						&& cell.getY() == field.getReplicator().getPosition().getY()) {
					hitReplicator = true;
					canGoFurther = false;
				}
			}
			if (cell instanceof Wall) {
				canGoFurther = false;
			}
		}

		Direction portalDir = null;

		if (hitReplicator) {
			field.setReplicator(null);
			return null;
		}

		if (cell instanceof SpecialWall) {
			cell = (SpecialWall) cell;
			switch (dir) {
			case DOWN:
				portalDir = Direction.UP;
				break;
			case LEFT:
				portalDir = Direction.RIGHT;
				break;
			case RIGHT:
				portalDir = Direction.LEFT;
				break;
			case UP:
				portalDir = Direction.DOWN;
				break;
			}
			Portal newPortal = new Portal(portalDir, col, (SpecialWall) cell);
			((SpecialWall) cell).setPortal(newPortal);
			return newPortal;
		}
		return null;
	}

	public void kill() {
		field.Initialize(field.getLevel());
	}

	@Override
	public void moveTo(Cell cell, Direction dir) {
		// If we were standing on a switch then we need to call the steppedoff
		// method on it before moving elsewhere
		if (wasOnSwitch) {
			((Switch) this.position).steppedOff();
		}
		this.dir = dir;
		this.setPosition(cell);
		cell.interact(this, dir);
		if (cell instanceof Switch) {
			wasOnSwitch = true;
		} else {
			wasOnSwitch = false;
		}
		this.field.print();
	}

	public void pickUpZpm() {
		zpmCount++;
		field.zpmPickedUp();
	}

	public void bindPortals() {
		if ((firstPortal != null) && (secondPortal != null)) {
			firstPortal.setPortsTo(secondPortal);
			secondPortal.setPortsTo(firstPortal);
		}
	}
}
