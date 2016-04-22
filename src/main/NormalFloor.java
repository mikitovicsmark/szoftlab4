package main;

public class NormalFloor extends Cell implements Interactable {

	public NormalFloor(int x, int y, Cell item) {
		super(x, y);
		this.setImage('.');
		if(item != null){
			if(item instanceof Box){
				box = (Box) item;
			}else if(item instanceof Zpm){
				zpm = (Zpm) item;
			}
		}
	}
	
	private Box box;
	private Zpm zpm;
	
	public boolean interact(Player player, Direction dir){
		if(box != null){
			player.setBox(box);
			box = null;
			return true;
		}
		if(zpm != null){
			player.pickUpZpm();
			zpm = null;
		}
		return true;
	}

}
