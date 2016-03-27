package skeleton;

public class Door extends Wall{
	@Override
	public void interact() {
		Scheduler.Print("Egy nyitott ajtoban all.");
	}
	public void open() {
		Scheduler.Print("Az ajto kinyilt.");
	}
	public void close() {
		Scheduler.Print("Az ajto bezarult.");
	}
	@Override
	public void shootWithPortal(Portal p) {
		Scheduler.Print("Az ajtot meglottek egy portallal, nem volt hatasos.");
	}
	public void shootThroughPortal(Direction dir, Wall wall) {
		Scheduler.Print("A jatekos kilott "+ dir +" egy portalt.");
		Scheduler.Print("Az ajton atrepult a portal.");
		wall.shootWithPortal(new Portal());
	}
}
