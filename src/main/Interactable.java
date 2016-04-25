package main;

public interface Interactable {
	public abstract boolean interact(Player player, Direction dir);
	public abstract boolean interact(Replicator replicator, Direction dir);
}
