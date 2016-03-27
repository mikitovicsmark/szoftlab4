package skeleton;

public class Portal {
	public Portal getDestinationPortal() {
		throw new UnsupportedOperationException();
	}

	public void setDestinationPortal(Portal p) {
		Scheduler.Print("A portal célállomása a másik portalra lett állítva");
	}
	public void setDirection(Direction dir){
		switch(dir){
		case LEFT: Scheduler.Print("A portal a fal keleti oldalán");
		break;
		case RIGHT: Scheduler.Print("A portal a fal nyugati oldalán");
		break;
		case UP: Scheduler.Print("A portal a fal déli oldalán");
		break;
		case DOWN: Scheduler.Print("A portal a fal északi oldalán");
		break;
		}

	}
	public Portal getDestination(){
		Scheduler.Print("A Portal megadja célállomásának koordinátáit");
		return new Portal();
	}
}
