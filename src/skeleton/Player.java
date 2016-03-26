package skeleton;

public class Player extends Move {
	public <I extends Interactable> void moveTo(String dir, I interactable ) {
		Scheduler.Print("A jatekos "+ dir + " lepett.");
		interactable.interact();
	}

	public <W extends Wall> void shootYellowPortal(String dir, W wall) {
		Scheduler.Print("A jatekos "+ dir +" kilott egy Sarga portalt.");
		wall.shootWithPortal();
	}

	public <W extends Wall> void shootBluePortal(String dir, W wall) {
		Scheduler.Print("A jatekos "+ dir +" kilott egy Kek portalt.");
		wall.shootWithPortal();
	}

	public <W extends Wall> void shootPortalThroughDoor(Door door, String dir, W wall) {
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
