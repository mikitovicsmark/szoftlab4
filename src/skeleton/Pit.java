package skeleton;

public class Pit extends NormalFloor {

	public void Interact(Player player) {
		Scheduler.Print("A j�t�kos r�l�pett a szakad�kra");
		player.die();
	}
}
