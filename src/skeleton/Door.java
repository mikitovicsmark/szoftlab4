package skeleton;

public class Door extends Wall{
	@Override
	public void Interact() {
		super.Interact();
		Scheduler.Print("Egy nyitott ajtóban áll.");	
	}
	public void Open() {	
		Scheduler.Print("Az ajtó kinyílt.");
	}
	@Override
	public void ShootWithPortal() {
		Scheduler.Print("Az ajtót meglõtték egy portallal, nem volt hatásos.");
	}
	public void ShootThroughPortal(String dir, Wall wall) {
		Scheduler.Print("A játékos kilõtt "+ dir +" egy portalt.");
		Scheduler.Print("Az ajtón átrepült a portal.");
		wall.ShootWithPortal();
	}
}
