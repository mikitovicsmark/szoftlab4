package skeleton;

public class Player extends Move {
	public <I extends Interactable> void moveTo(Direction dir, I interactable ) {
		Scheduler.Print("A jatekos "+ dir +" iranyba lepett.");
		interactable.interact();
	}

	public <W extends Wall> void shootYellowPortal(Direction dir, W wall) {
		Scheduler.Print("A jatekos "+ dir +" iranyba kilott egy Sarga portalt.");
		wall.shootWithPortal();
	}

	public <W extends Wall> void shootBluePortal(Direction dir, W wall) {
		Scheduler.Print("A jatekos "+ dir +" iranyba kilott egy Kek portalt.");
		wall.shootWithPortal();
	}

	public <W extends Wall> void shootPortalThroughDoor(Door door, Direction dir, W wall) {
		door.shootThroughPortal(dir, wall);
	}
	
	public <N extends NormalFloor> void putDownBox(N normalFloor) {
		Scheduler.Print("A jatekos lerakja a dobozt");
		normalFloor.putDownBox();
	}
	
	public <N extends NormalFloor> void pickUpBox(N normalFloor) {
		Scheduler.Print("A jatekos felveszi a dobozt");
		normalFloor.pickUpBox();
	}
	
}
