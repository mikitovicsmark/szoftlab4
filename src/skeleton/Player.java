package skeleton;

public class Player {
	public <I extends Interactable> void moveTo(String dir, I interactable ) {
		Scheduler.Print("A j�t�kos "+ dir + " l�pett.");
		interactable.Interact();	
	}
	
	public <W extends Wall> void ShootYellowPortal(String dir, W wall) {
		Scheduler.Print("A j�t�kos "+ dir +" kil�tt egy S�rga portalt.");
		wall.ShootWithPortal();
	}
	
	public <W extends Wall> void ShootBluePortal(String dir, W wall) {
		Scheduler.Print("A j�t�kos "+ dir +" kil�tt egy K�k portalt.");
		wall.ShootWithPortal();
	}
	
	public <W extends Wall>void ShootPortalThroughDoor(Door door, String dir, W wall) {
		door.ShootThroughPortal(dir, wall);
	}
}
