package skeleton;

public class Portal {
	private String direction;
	private Portal _portsTo;
	private Cell _location;
	public SpecialWall _unnamed_SpecialWall_;
	public Player _unnamed_Player_;

	public Portal getDestinationPortal() {
		throw new UnsupportedOperationException();
	}

	public void setDestinationPortal(Portal aPortal) {
		throw new UnsupportedOperationException();
	}

	public void setDirection(String aDir) {
		direction = aDir;
	}

	public String getDirection() {
		return direction;
	}
}
