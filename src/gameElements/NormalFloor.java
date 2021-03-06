package gameElements;

import enums.Direction;
import interfaces.Interactable;

public class NormalFloor extends Cell implements Interactable {
	private Box box;
	private Zpm zpm;
	
	public NormalFloor(int x, int y, Cell item) {
		super(x, y);
		this.setImage('.');
		if(item != null){
			if(item instanceof Box){
				box = (Box) item;
				this.setImage('B');
			}else if(item instanceof Zpm){
				zpm = (Zpm) item;
				this.setImage('Z');
			}
		}
	}
	
	public boolean interact(Player player, Direction dir){
		if(zpm != null){
			player.pickUpZpm();
			zpm = null;
			this.setImage('.');
		}
		return true;
	}
	
	public Box pickUpBox(){
		Box temp = box;
		box = null;
		this.setImage('.');
		return temp;
	}
	
	public void putDownBox(Box b){
		box = b;
		this.setImage('B');
	}

	public boolean hasBox(){
		return box!=null;
	}

	//interact with Replicator
	public boolean interact(Replicator replicator, Direction dir){
		return false;
	}
	
	public void addZPM() {
		this.zpm = new Zpm(this.getX(), this.getY());
		this.setImage('Z');
	}
	public boolean hasZPM(){
		return zpm!=null;
	}

}
