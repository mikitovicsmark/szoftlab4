package skeleton;

public class NormalFloor extends Cell implements Interactable {
	public Zpm pickUpZPM() {
		Scheduler.Print("A jatekos felveszi a ZPM-et");
		Zpm zpm = new Zpm();
		zpm.interact();
		
		return new Zpm();
	}

	public Box pickUpBox() {
		Scheduler.Print("A jatekos felveszi a dobozta a normal floor-rol");
		return new Box();
	}

	public void putDownBox() {
		Scheduler.Print("Sima foldre lerakja a dobozt.");
	}

	public void interact() {
		Scheduler.Print("A jatekos normalFloor-ra lepett.");
	}
}
