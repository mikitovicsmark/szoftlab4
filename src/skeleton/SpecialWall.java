package skeleton;

public class SpecialWall extends Wall {
	public void interact() {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public void shootWithPortal() {
		Scheduler.Print("A falat meglottuk egy portallal, kapu nyilt rajta.");
	}
}
