package skeleton;

public class SpecialWall extends Wall {
	public void interact(Player p) {
		Scheduler.Print("A Speci�lis fal elk�ri a rajta l�v� Portal"
				+ " c�l�llom�s�nak koordin�t�it, majd a koordin�t�kra mozgatja a j�t�kost");
		
	}
	
	@Override
	public void shootWithPortal() {
		Scheduler.Print("A falat meglottuk egy portallal, kapu nyilt rajta.");
	}
	public boolean getPassable(){
		return true;
	}
	public void setPortal(Portal p){
		Scheduler.Print("Az speci�lis falon portal ny�lt");
	}
	public void setPassable(boolean b){
		if (b){
			Scheduler.Print("A falon l�v� Portalon �t lehet haladni");
		}
		Scheduler.Print("A falon nem lehet �thaladni");
	}
}
