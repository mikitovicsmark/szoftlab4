package skeleton;

public class SpecialWall extends Wall {
	public void interact(Player p) {
		Scheduler.Print("A speci�lis falon ny�lt portalba l�p a j�t�kos");
		Portal port = new Portal();
		port.getDestination();
		p.moveTo(Direction.LEFT, new NormalFloor());
	}
	
	@Override
	public void shootWithPortal() {
		Scheduler.Print("A falat meglottuk egy portallal");
	}
	public boolean getPassable(){
		return true;
	}
	public void setPortal(Portal p){
		Scheduler.Print("Az speci�lis falon portal ny�lt");
	}
	public void setPassable(boolean b){
		if (b)
			Scheduler.Print("A falon l�v� Portalon mostm�r �t lehet haladni");
		else
			Scheduler.Print("A falon mostm�r nem lehet �thaladni");
	}
}
