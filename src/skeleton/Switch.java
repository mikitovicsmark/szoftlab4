package skeleton;

public class Switch extends Cell{
	
	public void Interact() {
		Scheduler.Print("R�l�pett egy kapcsol�ra.");
		Door door = new Door();
		door.Open();
	}
}
