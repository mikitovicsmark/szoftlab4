package skeleton;

public class Exit extends Wall{
	public void Interact(Player player) {
		Scheduler.Print("A j�t�kos r�l�pett az Exitre");
		int zpm = player.getZpmCount();
		if(zpm==0){
			Scheduler.Print("A j�t�kos teljes�tette a szintet");
		}
		else{
			Scheduler.Print("A j�t�kos m�g nem vett fel minden zpmet");
		}
	}
}
