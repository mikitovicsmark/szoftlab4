package skeleton;

public class Cell implements Interactable{
	public void setCoordinates() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void interact() {
		Scheduler.Print("Egy ures cellara erkezett.");
	}
}
