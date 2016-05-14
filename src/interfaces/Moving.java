package interfaces;

import enums.Direction;
import gameElements.Cell;

public interface Moving {
	public abstract void moveTo(Cell cell, Direction dir);
}
