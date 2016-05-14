package interfaces;

import enums.Direction;
import gameElements.Player;
import gameElements.Replicator;

public interface Interactable {
	public abstract boolean interact(Player player, Direction dir);
	public abstract boolean interact(Replicator replicator, Direction dir);
}
