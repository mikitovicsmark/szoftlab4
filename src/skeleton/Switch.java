package skeleton;

public class Switch extends NormalFloor{
	private Door _door;
	private Box _box;
	public Door _unnamed_Door_;

	public Box pickUpBox() {
		throw new UnsupportedOperationException();
	}

	public void putDownBox(Box aB) {
		throw new UnsupportedOperationException();
	}

	public void interact(Player aPlayer) {
		Scheduler.Print("Ralepett egy kapcsolora.");
		Door door = new Door();
		door.open();
	}
}
