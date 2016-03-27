package skeleton;

public class SpecialWall extends Wall {
	public void interact(Player p) {
		Scheduler.Print("A speciális falon lévõ portalba lép a játékos");
		Portal port = new Portal();
		port.getDestination();
		p.moveTo(Direction.LEFT, new NormalFloor());
	}
	
	@Override
	public void shootWithPortal(Portal p) {
		Scheduler.Print("A speciális falat meglottuk egy portallal");
	}
	public boolean getPassable(){
		return true;
	}
	public void setPortal(Portal p){
		Scheduler.Print("A falon portal nyílt");
	}
	public void setPassable(boolean b){
		if (b)
			Scheduler.Print("A falon lévõ Portalon mostmár át lehet haladni");
		else
			Scheduler.Print("A falon mostmár nem lehet áthaladni");
	}
}
