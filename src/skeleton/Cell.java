package skeleton;

public class Cell implements Interactable{
	private int _x;
	private int _y;
	/*private Image _image;

	public Image getImage() {
		return this._image;
	}

	public void setImage(Image aImage) {
		this._image = aImage;
	}*/

	public void setCoordinates(int aX, int aY) {
		throw new UnsupportedOperationException();
	}

	public int getX() {
		return this._x;
	}

	public int getY() {
		return this._y;
	}

	@Override
	public void interact(Player aPlayer) {
		Scheduler.Print("Egy ures cellara erkezett.");
	}
}
