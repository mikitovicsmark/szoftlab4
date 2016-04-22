package main;

import java.util.ArrayList;

public class Switch extends NormalFloor {
	Door door;
	ArrayList<Box> boxList;
	int openWeight;
	
	public Switch(int x, int y, Door d) {
		super(x, y, null);
		this.setImage('S');
		door = d;
	}
	
	public void putDownBox(Box box){
		boxList.add(box);
		if (getBoxListWeight() >= openWeight) {
			door.open();
		}
	}
	
	public Box pickUpBox(Player player){
		Box topBox = boxList.get(boxList.size() - 1);
		boxList.remove(boxList.size() - 1);
		
		if (getBoxListWeight() < openWeight){
			door.close();
		}
		
		return topBox;	
	}
	
	private int getBoxListWeight(){
		int weightSum = 0;
		
		for (int i = 0; i < boxList.size(); i++) {
			weightSum += boxList.get(i).weight;
		}
		
		return weightSum;
	}
	
	public boolean interact(Player player, Direction dir){
		door.open();
		return true;
	}
}
