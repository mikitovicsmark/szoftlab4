package skeleton;

public class Wall extends Cell implements Interactable{
	private boolean _isPassable;

	public boolean getPassable() {
		throw new UnsupportedOperationException();
	}

	public void setPassable(boolean aB) {
		throw new UnsupportedOperationException();
	}

	public void Interact(Player aPlayer) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void interact(Player aPlayer) {
		Scheduler.Print("A jatekos falnak ment.");
	}

	public void shootWithPortal() {
		Scheduler.Print("A falat meglottuk egy portallal, nem volt hatasos.");
	}
}
