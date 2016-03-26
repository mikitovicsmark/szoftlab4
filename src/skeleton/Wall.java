package skeleton;

public class Wall extends Cell implements Interactable{

	@Override
	public void Interact() {
		Scheduler.Print("A játékos falnak ment.");
	}
	
	public void ShootWithPortal() {
		Scheduler.Print("A falat meglõtték egy portallal, nem volt hatásos.");
	}
}
