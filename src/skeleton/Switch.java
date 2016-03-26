package skeleton;

public class Switch extends NormalFloor{
	public Box pickUpBox() {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public void putDownBox() {
		Scheduler.Print("Egy kapcsolra lerakja a dobozt");
	}

	public void interact() {
		Scheduler.Print("Ralepett egy kapcsolora.");
		Door door = new Door();
		door.open();
	}
}
