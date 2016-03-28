package skeleton;

public class Pit extends NormalFloor {

	public void Interact(Player player) {
		Scheduler.Print("A játékos rálépett a szakadékra");
		player.die();
	}
}
