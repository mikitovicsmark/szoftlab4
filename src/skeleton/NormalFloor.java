package skeleton;

public class NormalFloor extends Cell implements Interactable {
	public Zpm pickUpZPM() {
		throw new UnsupportedOperationException();
	}

	public Box pickUpBox() {
		throw new UnsupportedOperationException();
	}

	public void putDownBox() {
		Scheduler.Print("Sima foldre lerakja a dobozt.");
	}

	public void interact() {
		Scheduler.Print("Felveszi az ott l�v� dobozt vagy ZPM-et.");
	}
}
