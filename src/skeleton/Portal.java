package skeleton;

public class Portal {
	public Portal getDestinationPortal() {
		throw new UnsupportedOperationException();
	}

	public void setDestinationPortal(Portal p) {
		Scheduler.Print("A portal c�l�llom�sa a m�sik portalra lett �ll�tva");
	}
	public void setDirection(Direction dir){
		switch(dir){
		case LEFT: Scheduler.Print("A portal a fal keleti oldal�n");
		break;
		case RIGHT: Scheduler.Print("A portal a fal nyugati oldal�n");
		break;
		case UP: Scheduler.Print("A portal a fal d�li oldal�n");
		break;
		case DOWN: Scheduler.Print("A portal a fal �szaki oldal�n");
		break;
		}

	}
	public Portal getDestination(){
		Scheduler.Print("A Portal megadja c�l�llom�s�nak koordin�t�it");
		return new Portal();
	}
}
