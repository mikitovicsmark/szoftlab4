package skeleton;

public class Exit extends Wall{
	public void Interact(Player player) {
		Scheduler.Print("A játékos rálépett az Exitre");
		int zpm = player.getZpmCount();
		if(zpm==0){
			Scheduler.Print("A játékos teljesítette a szintet");
		}
		else{
			Scheduler.Print("A játékos még nem vett fel minden zpmet");
		}
	}
}
