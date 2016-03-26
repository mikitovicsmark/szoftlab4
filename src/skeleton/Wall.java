package skeleton;

public class Wall extends Cell implements Interactable{

	@Override
	public void Interact() {
		Scheduler.Print("A j�t�kos falnak ment.");
	}
	
	public void ShootWithPortal() {
		Scheduler.Print("A falat megl�tt�k egy portallal, nem volt hat�sos.");
	}
}
