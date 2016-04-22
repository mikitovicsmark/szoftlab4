package main;

import java.util.ArrayList;
import java.util.List;

public class GameField {

	private int level;	
	private Player player;
	private List<List<Cell>> cells = new ArrayList<List<Cell>>();
	private int height;
	private int width;
	private Exit exit;
	private int zpmCount;

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public void Initialize(int startLevel) {
		level = startLevel;
		List<String> stringLines = new Serializer().loadMap(level);
		width = stringLines.get(0).length();
		height = stringLines.size();
		zpmCount = 0;

		for (int i = 0; i < height; i++) {
			List<Cell> line = new ArrayList<Cell>();
			for (int j = 0; j < width; j++) {
				char nextCell = stringLines.get(i).charAt(j);
				switch (nextCell) {
				case 'Z':
					zpmCount++;
					line.add(new NormalFloor(j, i, new Zpm(j, i)));
					break;
				case 'B':
					line.add(new NormalFloor(j, i, new Box(j, i, 5))); // TODO change from fix 5 weight for box
					break;
				case 'E':
					Exit newExit = new Exit(j, i);
					exit = newExit;
					line.add(newExit);
					break;
				case 'P':
					line.add(new Pit(j, i));
					break;
				case '.':
					line.add(new NormalFloor(j, i, null));
					break;
				case '|':
					line.add(new Wall(j, i));
					break;
				case 'O':
					Cell floor = new NormalFloor(j, i, null);
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

	public void loadNextLevel() {
		level++;
		Initialize(level);
	}

	public int getLevel() {
		return level;
	}

	public void zpmPickedUp() {
		zpmCount--;
		if(zpmCount <= 0){
			exit.openExit();
		}	
	}
}
