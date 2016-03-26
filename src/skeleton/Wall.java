package skeleton;

public class Wall extends Cell implements Interactable{
	@Override
	public void interact() {
		Scheduler.Print("A jatekos falnak ment.");
	}

	public void shootWithPortal() {
		Scheduler.Print("A falat meglottuk egy portallal, nem volt hatasos.");
	}
}
