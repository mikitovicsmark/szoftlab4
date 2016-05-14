package main;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import enums.Color;
import enums.Direction;
import gameElements.NormalFloor;

public class GamePanel extends JPanel implements KeyListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6644375181764124582L;
	
	private Image weight, door, zpm, box, exit, pit, normalFloor, wall, specialWall,
		replicator, oneill, bluePortal, yellowPortal;

	private GameField gameField;
	
	public GamePanel() {
		this.gameField = new GameField();
		try {
		this.weight = ImageIO.read(new File("src/images/switch.png"));
		this.door = ImageIO.read(new File("src/images/doorClosed.png"));
		this.zpm = ImageIO.read(new File("src/images/zpm.png"));
		this.box = ImageIO.read(new File("src/images/box.png"));
		this.exit = ImageIO.read(new File("src/images/exit_closed.png"));
		this.pit = ImageIO.read(new File("src/images/pit.png"));
		this.normalFloor = ImageIO.read(new File("src/images/floor.png"));
		this.wall = ImageIO.read(new File("src/images/wall.png"));
		this.specialWall = ImageIO.read(new File("src/images/specialwall.png"));
		this.replicator = ImageIO.read(new File("src/images/replicator.png"));
		this.oneill = ImageIO.read(new File("src/images/character.png"));
		this.bluePortal = ImageIO.read(new File("src/images/blueportal.png"));
		this.yellowPortal = ImageIO.read(new File("src/images/orangeportal.png"));
		}
		catch (IOException e) {
			e.printStackTrace();
		} 
//		
	}
	
	public void paint(Graphics g) {
        super.paintComponent(g);
		for(int i=0; i<this.gameField.getHeight(); i++){
			for (int j=0; j<this.gameField.getWidth(); j++) {
				switch(this.gameField.getCell(j, i).getImage()){
				case 'W': //weight
					g.drawImage(weight, j*40, i*40, null);
                    break;
                case 'D': //door
                	g.drawImage(door, j*40, i*40, null);
                    break;
                case 'Z': //zpm
                	g.drawImage(zpm, j*40, i*40, null);
                    break;
                case 'B': //box
                	g.drawImage(box, j*40, i*40, null);
                    break;
                case 'E': //exit
                	g.drawImage(exit, j*40, i*40, null);
                	break;
                case 'P': //pit
                	g.drawImage(pit, j*40, i*40, null);
                    break;
                case '.': //normalfloor
                	if (this.gameField.getCell(j, i) == gameField.player.getPosition()) {
                		g.drawImage(oneill, j*40, i*40, null);
    				}
    				else if (gameField.replicator != null && this.gameField.getCell(j, i) == gameField.replicator.getPosition()){
    					g.drawImage(replicator, j*40, i*40, null);
    				}
    				else {
    					g.drawImage(normalFloor, j*40, i*40, null);
    				}
                    break;
                case '|': //wall
                	g.drawImage(wall, j*40, i*40, null);
                    break;
                case 'L': //specialwall
                	g.drawImage(specialWall, j*40, i*40, null);
                    break;
				case 'R': //replicator
					g.drawImage(replicator, j*40, i*40, null);
					break;
                case 'O': // Oneill
                	g.drawImage(oneill, j*40, i*40, null);
                	break;
				case 'K': //BLUE Portal
					g.drawImage(bluePortal, j*40, i*40, null);
				    break;
				case 'S': //YELLOW Portal
					g.drawImage(weight, j*40, i*40, null);
                    break;
                default :
                	g.drawImage(normalFloor, j*40, i*40, null);
                    break;
                }
			}
		}
    }
	
	public void setGameField(GameField gameField) {
		this.gameField=gameField;	
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		int playerX = gameField.getPlayer().getPosition().getX();
		int playerY = gameField.getPlayer().getPosition().getY();
		switch (e.getKeyChar()) {
		case 'q':
			gameField.getPlayer().shootFirstPortal(Color.BLUE);
			break;
		case 'e':
			gameField.getPlayer().shootSecondPortal(Color.YELLOW);
			break;
		case 's':
			if (playerY < gameField.getHeight() - 1) {
				gameField.getPlayer().moveTo(gameField.getCell(playerX, playerY + 1), Direction.DOWN);
			}
			break;
		case 'a':
			if (playerX > 0) {
				gameField.getPlayer().moveTo(gameField.getCell(playerX - 1, playerY), Direction.LEFT);
			}
			break;
		case 'w':
			if (playerY > 0) {
				gameField.getPlayer().moveTo(gameField.getCell(playerX, playerY - 1), Direction.UP);
			}
			break;
		case 'd':
			if (playerX < gameField.getWidth() - 1) {
				gameField.getPlayer().moveTo(gameField.getCell(playerX + 1, playerY), Direction.RIGHT);
			}
			break;
			//Pressing the F key on a NormalFloor that has a Box on it results in the player picking it up
			//If the player has a box and is standing on an empty NormalFloor the box will be placed on the floor
		case 'f':
			//Checking if the current Cell is a NormalFloor, otherwise moving on to break
			if(gameField.getCell(playerX, playerY)instanceof NormalFloor){
				//The scenario of picking up a box from the floor
				if (gameField.getPlayer().getBox()==null){
					if (((NormalFloor) gameField.getCell(playerX, playerY)).hasBox()){
						//Setting the current box in the players inventory to be the one that was on the floor
						gameField.getPlayer().setBox(((NormalFloor) gameField.getCell(playerX, playerY)).pickUpBox());
					}
				}
				//Scenario of putting down an already equipped box
				else{
					//If the NormalFloor has no box on it, the current box is placed then removed from the player's inventory 
					if(!((NormalFloor) gameField.getCell(playerX, playerY)).hasBox() && gameField.getPlayer().getBox()!=null){
						((NormalFloor) gameField.getCell(playerX, playerY)).putDownBox(gameField.getPlayer().getBox());
						gameField.getPlayer().setBox(null);
					}
				}
			}
			break;
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}