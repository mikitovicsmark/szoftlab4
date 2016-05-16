package gameElements;

import java.util.ArrayList;

import enums.Direction;

public class Switch extends NormalFloor {
	Door door;
	ArrayList<Box> boxList;
	int openWeight;
	int ID;

	public Switch(int x, int y, Door d, int openWeight, int nwid) {
		super(x, y, null);
		boxList = new ArrayList<Box>();
		this.setImage('S');
		door = d;
		ID = nwid;
		boxList = new ArrayList<Box>();
		this.openWeight = openWeight;
	}

	public int getID() {
		return ID;
	}

	public void setDoor(Door d) {
		door = d;
	}

	public void putDownBox(Box box) {
		boxList.add(box);
		if (getBoxListWeight() >= openWeight) {
			door.open();
		}
	}

	public Box pickUpBox() {
		Box topBox = boxList.get(boxList.size() - 1);
		boxList.remove(boxList.size() - 1);
		if (getBoxListWeight() < openWeight) {
			door.close();
		}
		return topBox;
	}

	private int getBoxListWeight() {
		int weightSum = 0;

		for (int i = 0; i < boxList.size(); i++) {
			weightSum += boxList.get(i).weight;
		}

		return weightSum;
	}

	@Override
	public boolean interact(Player player, Direction dir) {
		// The weight of the already placed boxes + 1 for the weight of the
		// player (which is 1 unit)
		if (getBoxListWeight() + 1 >= openWeight) {
			door.open();
		}
		return true;
	}

	// The replicator does not interact with the switch
	public boolean interact(Replicator player, Direction dir) {
		return true;
	}

	public void steppedOff() {
		if (getBoxListWeight() < openWeight) {
			door.close();
		}
	}

	public boolean isEmpty() {
		return getBoxListWeight() == 0;
	}
}
