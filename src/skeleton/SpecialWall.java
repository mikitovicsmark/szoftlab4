package skeleton;

public class SpecialWall extends Wall {
	public void interact(Player p) {
		Scheduler.Print("A Speciális fal elkéri a rajta lévõ Portal"
				+ " célállomásának koordinátáit, majd a koordinátákra mozgatja a játékost");
		
	}
	
	@Override
	public void shootWithPortal() {
		Scheduler.Print("A falat meglottuk egy portallal, kapu nyilt rajta.");
	}
	public boolean getPassable(){
		return true;
	}
	public void setPortal(Portal p){
		Scheduler.Print("Az speciális falon portal nyílt");
	}
	public void setPassable(boolean b){
		if (b){
			Scheduler.Print("A falon lévõ Portalon át lehet haladni");
		}
		Scheduler.Print("A falon nem lehet áthaladni");
	}
}
