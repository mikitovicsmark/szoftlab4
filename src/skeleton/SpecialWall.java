package skeleton;

public class SpecialWall extends Wall {
	private Portal _portal;
	public Portal _unnamed_Portal_;

	public Portal getPortal() {
		return this._portal;
	}

	public void setPortal(Portal aP) {
		this._portal = aP;
	}

	public void interact(Player aPlayer) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public void shootWithPortal() {
		Scheduler.Print("A falat meglottuk egy portallal, kapu nyilt rajta.");
	}
}
