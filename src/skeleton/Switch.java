package skeleton;

public class Switch extends Cell{
	
	public void Interact() {
		Scheduler.Print("Rálépett egy kapcsolóra.");
		Door door = new Door();
		door.Open();
	}
}
