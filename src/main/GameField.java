package main;
 
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import enums.Color;
import enums.Direction;
import gameElements.*;

public class GameField {
	Replicator replicator;
    private int level;
    Player player;
    Player jaffa;
    private List<List<Cell>> cells = new ArrayList<List<Cell>>();
    private int height;
    private int width;
    private Exit exit;
    private int zpmCount;

    private int realX = 0;
    private int realY = 0;

	public Replicator getReplicator() { return replicator; }

	public void setReplicator(Replicator replicator) { this.replicator = replicator; }

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

	public Cell getCell(int x, int y) {
		return cells.get(y).get(x);
	}

	public void setCell(int x, int y, Cell cell){
		this.cells.get(y).set(x, cell);
	}

	public void print() {
		for (List<Cell> row : cells) {
			for (Cell cell : row) {
				if (cell == this.player.getPosition()) {
					System.out.print(this.player.getImage());
				}
                else if (cell == this.jaffa.getPosition()) {
                    System.out.print(this.jaffa.getImage());
                }
				else if (this.replicator != null && cell == this.replicator.getPosition()){
					System.out.print(this.replicator.getImage());
				}
				else {
					System.out.print(cell.getImage());
				}

			}
			System.out.println("");
		}
	}

    public Player getPlayer() {
        return player;
    }

    public Player getJaffa(){ return jaffa; }
 
    public void setPlayer(Player player) {
        this.player = player;
    }
 
    public void Initialize(int startLevel) {
        //reset map
    	realX=0;
    	realY=0;
        cells = new ArrayList<List<Cell>>();
        level = startLevel;
        List<String> stringLines = new Serializer().loadMap(level);
        zpmCount = 0;
 
        for (int i = 0; i < stringLines.size(); i++) {
            List<Cell> line = new ArrayList<Cell>();
            for (int j = 0; j < stringLines.get(i).length(); j++) {
                char nextCell = stringLines.get(i).charAt(j);
                switch (nextCell) {
                case 'W':
                    int openWeight = java.lang.Character.getNumericValue(stringLines.get(i).charAt(j+1));
                    int sID = java.lang.Character.getNumericValue(stringLines.get(i).charAt(j+2));
                    line.add(new Switch(realX, realY, null,openWeight,sID));
                    realX++;
                    break;
                case 'D':
                    int dID = java.lang.Character.getNumericValue(stringLines.get(i).charAt(j+1));
                    line.add(new Door(realX, realY, null,dID));
                    realX++;
                    break;
                case 'Z':
                    zpmCount++;
                    line.add(new NormalFloor(realX, realY, new Zpm(j, i)));
                    realX++;
                    break;
                case 'B':
                    line.add(new NormalFloor(realX, realY, new Box(realX, realY, 1))); // TODO change from fix 5 weight for box
                    realX++;
                    break;
                case 'E':
                    Exit newExit = new Exit(realX, realY);
                    exit = newExit;
                    line.add(newExit);
                    realX++;
                    break;
                case 'P':
                    line.add(new Pit(realX, realY));
                    realX++;
                    break;
                case '.':
                    line.add(new NormalFloor(realX, realY, null));
                    realX++;
                    break;
                case '|':
                    line.add(new Wall(realX, realY));
                    realX++;
                    break;
                case 'L':
                    line.add(new SpecialWall(realX, realY));
                    realX++;
                    break;
				case 'R':
					Cell floor2 = new NormalFloor(realX, realY, null);
					this.replicator = new Replicator(floor2);
					this.replicator.setPosition(floor2);//PREVIOUSLY: this.player = new Player(floor); // no need for a new player to create.
					this.replicator.setField(this);
					line.add(floor2);
					realX++;
					break;
                case 'O':
                    Cell floor = new NormalFloor(realX, realY, null);
                    this.player = new Player(floor);
                    this.player.setPosition(floor);//PREVIOUSLY: this.player = new Player(floor); // no need for a new player to create.
                    this.player.setField(this);
                    line.add(floor);
                    realX++;
		            break;
                case 'J':
                    Cell floor3 = new NormalFloor(realX, realY, null);
                    this.jaffa = new Jaffa(floor3);
                    this.jaffa.setPosition(floor3);
                    this.jaffa.setField(this);
                    line.add(floor3);
                    realX++;
                    break;
		case 'K': //BLUE Portal
		    SpecialWall sp1 = new SpecialWall(realX, realY);
		    Portal kportal = new Portal(Direction.LEFT,Color.BLUE,sp1);//NOTE: default direction is LEFT, you need to change in the tests
		    sp1.setPortal(kportal);
		    player.setFirstPortal(kportal);
		    line.add(sp1);
		    realX++;
		    break;
		case 'S': //YELLOW Portal
		    SpecialWall sp2 = new SpecialWall(realX, realY);
		    Portal sportal = new Portal(Direction.LEFT,Color.YELLOW,sp2);//NOTE: default direction is LEFT, you need to change in the tests
		    sp2.setPortal(sportal);
		    player.setSecondPortal(sportal);
		    line.add(sp2);
		    realX++;
                    break;
                default :
                    break;
                }
            }
            cells.add(line);
            realY++;
            width = realX;
            height = realY;
            realX=0;
			for(List<Cell> clist : cells){
				for(Cell value : clist){
					if(value instanceof Door){
						int temp = ((Door)value).getID();
						for (List<Cell> loop2clist : cells){
							for(Cell loop2value : loop2clist){
								if(loop2value instanceof Switch){
									if(((Switch)loop2value).getID()==temp){
										((Switch)loop2value).setDoor((Door) value);
									}
								}
							}
						}
					}
				}
			}
        }
    }

 
    public void loadNextLevel() {
        level++;
        Initialize(level);
    }
 
    public int getLevel() {
        return level;
    }
   
    public void addZpm(int n){
        zpmCount += n;
    }
 
    public void zpmPickedUp() {
        zpmCount--;
        if(zpmCount <= 0){
            exit.openExit();
        }  
    }

	public void spawnRandomZPM() {
		Random random = new Random();	
		boolean spawnedRandomZPM = false;
		while(!spawnedRandomZPM) {
			int randomx = random.nextInt(this.width);
			int randomy = random.nextInt(this.height);
			Cell tempCell = this.getCell(randomx, randomy);
			if (tempCell instanceof NormalFloor && !(tempCell instanceof Switch) &&!(tempCell instanceof Pit)) {
				if (!((NormalFloor) tempCell).hasZPM()){
					((NormalFloor) tempCell).addZPM();
					spawnedRandomZPM = true;
					this.zpmCount++;
					System.out.println(this.zpmCount);
				}
			}
		}
		
	}
}
