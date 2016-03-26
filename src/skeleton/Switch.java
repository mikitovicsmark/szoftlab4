package skeleton;

public class Switch extends NormalFloor{
	public Box pickUpBox() {
		throw new UnsupportedOperationException();
	}

	public void putDownBox(Box aB) {
		throw new UnsupportedOperationException();
	}

	public void interact() {
		Scheduler.Print("Ralepett egy kapcsolora.");
		Door door = new Door();
		door.open();
	}
}
