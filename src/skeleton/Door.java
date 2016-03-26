package skeleton;

public class Door extends Wall{
	@Override
	public void Interact() {
		super.Interact();
		Scheduler.Print("Egy nyitott ajt�ban �ll.");	
	}
	public void Open() {	
		Scheduler.Print("Az ajt� kiny�lt.");
	}
	@Override
	public void ShootWithPortal() {
		Scheduler.Print("Az ajt�t megl�tt�k egy portallal, nem volt hat�sos.");
	}
	public void ShootThroughPortal(String dir, Wall wall) {
		Scheduler.Print("A j�t�kos kil�tt "+ dir +" egy portalt.");
		Scheduler.Print("Az ajt�n �trep�lt a portal.");
		wall.ShootWithPortal();
	}
}
