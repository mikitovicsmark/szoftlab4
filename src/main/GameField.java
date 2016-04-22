package main;

import java.util.ArrayList;
import java.util.List;

public class GameField {

	private Player player;

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	private List<List<Cell>> cells = new ArrayList<List<Cell>>();
	private int height;
	private int width;

	public void Initialize(List<String> stringLines) {

		width = stringLines.get(0).length();
		height = stringLines.size();

		for (int i = 0; i < height; i++) {
			List<Cell> line = new ArrayList<Cell>();
			for (int j = 0; j < width; j++) {
				char nextCell = stringLines.get(i).charAt(j);
				switch (nextCell) {
				case '.':
					line.add(new NormalFloor(j, i));
					break;
				case '|':
					line.add(new Wall(j, i));
					break;
				case 'O':
					Cell floor = new NormalFloor(j, i);
					this.player = new Player(floor);
					this.player.setField(this);
					line.add(floor);
					break;
				}
			}
			cells.add(line);
		}
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

	public Cell getCell(int x, int y) {
		return cells.get(y).get(x);
	}

	public void print() {
		for (List<Cell> row : cells) {
			for (Cell cell : row) {
				if (cell == this.player.getPosition()) {
					System.out.print(this.player.getImage());
				} else {
					System.out.print(cell.getImage());
				}

			}
			System.out.println("");
		}
	}

}
