package main;

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
		if(box != null){
			player.setBox(box);
			box = null;
			this.setImage('.');
			return true;
		}
		if(zpm != null){
			player.pickUpZpm();
			zpm = null;
			this.setImage('.');
		}
		return true;
	}

}
