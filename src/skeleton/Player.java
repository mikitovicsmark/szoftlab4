package skeleton;

public class Player {
	public <I extends Interactable> void moveTo(String dir, I interactable ) {
		Scheduler.Print("A játékos "+ dir + " lépett.");
		interactable.Interact();	
	}
	
	public <W extends Wall> void ShootYellowPortal(String dir, W wall) {
		Scheduler.Print("A játékos "+ dir +" kilõtt egy Sárga portalt.");
		wall.ShootWithPortal();
	}
	
	public <W extends Wall> void ShootBluePortal(String dir, W wall) {
		Scheduler.Print("A játékos "+ dir +" kilõtt egy Kék portalt.");
		wall.ShootWithPortal();
	}
	
	public <W extends Wall>void ShootPortalThroughDoor(Door door, String dir, W wall) {
		door.ShootThroughPortal(dir, wall);
	}
}
