package skeleton;

public class Player extends Move {
	public <I extends Interactable> void moveTo(Direction dir, I interactable ) {
		Scheduler.Print("A jatekos "+ dir +" iranyba lepett.");
		interactable.interact();
	}

	public <W extends Wall> void shootYellowPortal(Direction dir, W wall) {
		Scheduler.Print("A jatekos "+ dir +" iranyba kilott egy Sarga portalt.");
		Portal py = new Portal();
		wall.shootWithPortal(py);
		py.setDirection(dir);
		if (wall instanceof SpecialWall)
		((SpecialWall) wall).setPortal(new Portal());
		new Portal().setDestinationPortal(py);
		py.setDestinationPortal(py);
		}

	public <W extends Wall> void shootBluePortal(Direction dir, W wall) {
		Scheduler.Print("A jatekos "+ dir +" iranyba kilott egy Kek portalt.");
		Portal pb = new Portal();
		wall.shootWithPortal(pb);
		pb.setDirection(dir);
		if (wall instanceof SpecialWall)
		((SpecialWall) wall).setPortal(new Portal());
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
	
	public <N extends NormalFloor> void pickUpZpm(N normalFloor){
		Scheduler.Print("A jatekos felvenni keszul a ZPM-et.");
		normalFloor.pickUpZPM();
	}
	
	public int getZpmCount(){
		Scheduler.Print("A játékos felvett minden zpmet");
		return 0;
	}
	
	public void die(){
		Scheduler.Print("A jatekos meghalt");
	}
	
}
