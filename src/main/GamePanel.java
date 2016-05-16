package main;

import java.awt.Font;
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
import gameElements.Door;
import gameElements.NormalFloor;
import gameElements.Player;
import gameElements.SpecialWall;
import gameElements.Portal;
import gameElements.Switch;

public class GamePanel extends JPanel implements KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6644375181764124582L;

	private Image weight, openDoor, zpm, box, exitOpen, exitClosed, pit, normalFloor, wall, specialWall, replicator,
			oneill, jaffa, redPortalUP, redPortalDOWN, redPortalLEFT, redPortalRIGHT,
			greenPortalUP, greenPortalDOWN, greenPortalLEFT, greenPortalRIGHT,
			bluePortalRIGHT, yellowPortal, yellowPortalUP, bluePortalUP, bluePortalDOWN, bluePortalLEFT,
			yellowPortalDOWN, yellowPortalLEFT, yellowPortalRIGHT, closedDoor, smallBox, pinkSwitch, pinkDoorClosed,
			pinkDoorOpen, blueSwitch, blueDoorClosed, blueDoorOpen, greenSwitch, greenDoorClosed, greenDoorOpen, 
			player1UP, player1RIGHT, player1DOWN, player1LEFT,
			player2UP, player2DOWN, player2LEFT, player2RIGHT;

	private GameField gameField;

	public GamePanel() {
		this.gameField = new GameField();
		try {
			this.weight = ImageIO.read(new File("src/images/switch.png"));
			this.openDoor = ImageIO.read(new File("src/images/dooropen.png"));
			this.closedDoor = ImageIO.read(new File("src/images/doorclosed.png"));
			this.zpm = ImageIO.read(new File("src/images/zpm.png"));
			this.box = ImageIO.read(new File("src/images/box.png"));
			this.exitClosed = ImageIO.read(new File("src/images/exit_closed.png"));
			this.exitOpen = ImageIO.read(new File("src/images/exit_open.png"));
			this.pit = ImageIO.read(new File("src/images/pit.png"));
			this.normalFloor = ImageIO.read(new File("src/images/floor.png"));
			this.wall = ImageIO.read(new File("src/images/wall.png"));
			this.specialWall = ImageIO.read(new File("src/images/specialwall.png"));
			this.replicator = ImageIO.read(new File("src/images/replicator.png"));
			this.jaffa = ImageIO.read(new File("src/images/character2.png"));
			this.oneill = ImageIO.read(new File("src/images/character.png"));
			this.bluePortalUP = ImageIO.read(new File("src/images/specialwallBluePortalTop.png"));
			this.bluePortalDOWN = ImageIO.read(new File("src/images/specialwallBluePortalDown.png"));
			this.bluePortalLEFT = ImageIO.read(new File("src/images/specialwallBluePortalLeft.png"));
			this.bluePortalRIGHT = ImageIO.read(new File("src/images/specialwallBluePortalRight.png"));
			this.yellowPortalLEFT = ImageIO.read(new File("src/images/specialwallOrangePortalLeft.png"));
			this.yellowPortalRIGHT = ImageIO.read(new File("src/images/specialwallOrangePortalRight.png"));
			this.yellowPortalUP = ImageIO.read(new File("src/images/specialwallOrangePortalTop.png"));
			this.yellowPortalDOWN = ImageIO.read(new File("src/images/specialwallOrangePortalDown.png"));
			this.redPortalUP = ImageIO.read(new File("src/images/specialwallPinkPortalTop.png"));
			this.redPortalDOWN = ImageIO.read(new File("src/images/specialwallPinkPortalDown.png"));
			this.redPortalLEFT = ImageIO.read(new File("src/images/specialwallPinkPortalLeft.png"));
			this.redPortalRIGHT = ImageIO.read(new File("src/images/specialwallPinkPortalRight.png"));
			this.greenPortalUP = ImageIO.read(new File("src/images/specialwallGreenPortalTop.png"));
			this.greenPortalDOWN = ImageIO.read(new File("src/images/specialwallGreenPortalDown.png"));
			this.greenPortalLEFT = ImageIO.read(new File("src/images/specialwallGreenPortalLeft.png"));
			this.greenPortalRIGHT = ImageIO.read(new File("src/images/specialwallGreenPortalRight.png"));
			this.smallBox = ImageIO.read(new File("src/images/boxsmall.png"));
			this.pinkSwitch = ImageIO.read(new File("src/images/pinkswitch.png"));
			this.pinkDoorClosed = ImageIO.read(new File("src/images/pinkdoorclosedwithwall.png"));
			this.pinkDoorOpen = ImageIO.read(new File("src/images/pinkdoorwithwallopen.png"));
			this.blueSwitch = ImageIO.read(new File("src/images/blueswitch.png"));
			this.blueDoorClosed = ImageIO.read(new File("src/images/bluedoorclosed.png"));
			this.blueDoorOpen = ImageIO.read(new File("src/images/bluedoorwithwallopen.png"));
			this.greenSwitch = ImageIO.read(new File("src/images/greenswitch.png"));
			this.greenDoorClosed = ImageIO.read(new File("src/images/greendoorclosed.png"));
			this.greenDoorOpen = ImageIO.read(new File("src/images/greendoorwithwallopen.png"));
			this.player1UP = ImageIO.read(new File("src/images/player1Up.png"));
			this.player1DOWN = ImageIO.read(new File("src/images/player1Down.png"));
			this.player1LEFT = ImageIO.read(new File("src/images/player1Left.png"));
			this.player1RIGHT = ImageIO.read(new File("src/images/player1Right.png"));
			this.player2UP = ImageIO.read(new File("src/images/player2Up.png"));
			this.player2DOWN = ImageIO.read(new File("src/images/player2Down.png"));
			this.player2LEFT = ImageIO.read(new File("src/images/player2Left.png"));
			this.player2RIGHT = ImageIO.read(new File("src/images/player2Right.png"));

		} catch (IOException e) {
			e.printStackTrace();
		}
		//
	}
	
	public Image getPlayerDir(){
	Image paint4 = oneill;
	switch (this.gameField.player.getDirection()) {
		case UP:
			paint4 = player1UP;
		break;
		case LEFT:
			paint4 = player1LEFT;
		break;
		case RIGHT:
			paint4 = player1RIGHT;
		break;
		case DOWN:
			paint4 = player1DOWN;
		break;
		}
		return paint4;
	}

	public Image getJaffaDir(){
		switch (this.gameField.jaffa.getDirection()){
			case UP:
				return player2UP;
			case  LEFT:
				return player2LEFT;
			case RIGHT:
				return player2RIGHT;
			case DOWN:
				return player2DOWN;
			default:
				return player2LEFT;
		}
	}
	
	public void paint(Graphics g) {
		super.paintComponent(g);
		for (int i = 0; i < this.gameField.getHeight(); i++) {
			for (int j = 0; j < this.gameField.getWidth(); j++) {
				switch (this.gameField.getCell(j, i).getImage()) {
				case 'W': // weight
					g.drawImage(weight, j * 40, i * 40, null);
					break;
				case 'D': // open door
					Image Paint = openDoor;
					switch (((Door)this.gameField.getCell(j, i)).getID()) {
						case 5:
							Paint = pinkDoorOpen;
							break;
						case 4: 
							Paint = greenDoorOpen;
							break;
						case 3:
							Paint = blueDoorOpen;
							break;
						default: 
							Paint = openDoor;
							break;
					}
					g.drawImage(Paint, j * 40, i * 40, null);
					if (this.gameField.getCell(j, i) == gameField.player.getPosition()) {
						Image playerDirection = getPlayerDir();
						g.drawImage(playerDirection, j * 40, i * 40, null);
					} else if (gameField.replicator != null
							&& this.gameField.getCell(j, i) == gameField.replicator.getPosition()) {
						g.drawImage(replicator, j * 40, i * 40, null);
					}
					else if (this.gameField.getCell(j,i) == gameField.jaffa.getPosition()){
						g.drawImage(getJaffaDir(), j*40, i*40, null);
					}
					break;
				case 'd': // closed door
					g.drawImage(normalFloor, j * 40, i * 40, null);
					g.drawImage(closedDoor, j * 40, i * 40, null);
					if (gameField.replicator != null
							&& this.gameField.getCell(j, i) == gameField.replicator.getPosition()) {
						g.drawImage(replicator, j * 40, i * 40, null);
					}
					Image Paint2 = closedDoor;
					switch (((Door)this.gameField.getCell(j, i)).getID()) {
						case 5:
							Paint2 = pinkDoorClosed;
							break;
						case 4: 
							Paint2 = greenDoorClosed;
							break;
						case 3:
							Paint2 = blueDoorClosed;
							break;
						default: 
							Paint2 = closedDoor;
							break;
					}
					g.drawImage(Paint2, j * 40, i * 40, null);
					if (gameField.replicator != null
							&& this.gameField.getCell(j, i) == gameField.replicator.getPosition()) {
						g.drawImage(replicator, j * 40, i * 40, null);
					}
					break;
				case 'Z': // zpm
					g.drawImage(normalFloor, j * 40, i * 40, null);
					g.drawImage(zpm, j * 40, i * 40, null);
					if (gameField.replicator != null
							&& this.gameField.getCell(j, i) == gameField.replicator.getPosition()) {
						g.drawImage(replicator, j * 40, i * 40, null);
					}
					break;
				case 'B': // box
					g.drawImage(normalFloor, j * 40, i * 40, null);
					g.drawImage(smallBox, j * 40, i * 40, null);
					if (this.gameField.getCell(j, i) == gameField.player.getPosition()) {
						Image playerDirection = getPlayerDir();
						g.drawImage(playerDirection, j * 40, i * 40, null);
					}
					else if (this.gameField.getCell(j,i) == gameField.jaffa.getPosition()){
							g.drawImage(getJaffaDir(), j*40, i*40, null);
					}
					else if (gameField.replicator != null
							&& this.gameField.getCell(j, i) == gameField.replicator.getPosition()) {
						g.drawImage(replicator, j * 40, i * 40, null);
					}
					break;
				case 'E': // exit
					g.drawImage(normalFloor, j * 40, i * 40, null);
					g.drawImage(exitOpen, j * 40, i * 40, null);
					if (gameField.replicator != null
							&& this.gameField.getCell(j, i) == gameField.replicator.getPosition()) {
						g.drawImage(replicator, j * 40, i * 40, null);
					}
					break;
				case 'e': // exit
					g.drawImage(normalFloor, j * 40, i * 40, null);
					g.drawImage(exitClosed, j * 40, i * 40, null);
					if (gameField.replicator != null
							&& this.gameField.getCell(j, i) == gameField.replicator.getPosition()) {
						g.drawImage(replicator, j * 40, i * 40, null);
					}
					break;
				case 'P': // pit
					g.drawImage(pit, j * 40, i * 40, null);
					break;
				case '.': // normalfloor
					g.drawImage(normalFloor, j * 40, i * 40, null);
					if (this.gameField.getCell(j, i) == gameField.player.getPosition()) {
						Image playerDirection = getPlayerDir();
						g.drawImage(playerDirection, j * 40, i * 40, null);
					}
					else if (gameField.replicator != null
							&& this.gameField.getCell(j, i) == gameField.replicator.getPosition()) {
						g.drawImage(replicator, j * 40, i * 40, null);
					}
					else if (gameField.jaffa != null
							&& gameField.getCell(j,i) == gameField.jaffa.getPosition()) {
						g.drawImage(getJaffaDir(), j*40, i*40, null);
					}
					break;
				case '|': // wall
					g.drawImage(wall, j * 40, i * 40, null);
					if (gameField.replicator != null
							&& this.gameField.getCell(j, i) == gameField.replicator.getPosition()) {
						g.drawImage(replicator, j * 40, i * 40, null);
					}
					break;
				case 'L': // specialwall
					g.drawImage(specialWall, j * 40, i * 40, null);
					if (gameField.replicator != null
							&& this.gameField.getCell(j, i) == gameField.replicator.getPosition()) {
						g.drawImage(replicator, j * 40, i * 40, null);
					}
					break;
				case 'R': // replicator
					g.drawImage(replicator, j * 40, i * 40, null);
					break;
				case 'J': // Jaffa
					g.drawImage(jaffa, j * 40, i * 40, null);
					break;
				case 'O': // Oneill
					//ennek itt nem volt sok ertelme
					g.drawImage(oneill, j*40, i*40, null);
					break;
				case 'T': // Portal
					g.drawImage(specialWall, j * 40, i * 40, null);
					Portal tempPortal = ((SpecialWall) this.gameField.getCell(j, i)).getPortal();
					Image toPaint = null;
					switch (tempPortal.getDirection()) {
					case UP:
						if (tempPortal.getColor() == Color.BLUE) {
							toPaint = bluePortalUP;
						} else if (tempPortal.getColor() == Color.YELLOW) {
							toPaint = yellowPortalUP;
						}
						else if (tempPortal.getColor() == Color.RED){
							toPaint = redPortalUP;
						}
						else if (tempPortal.getColor() == Color.GREEN){
							toPaint = greenPortalUP;
						}
						break;
					case DOWN:
						if (tempPortal.getColor() == Color.BLUE) {
							toPaint = bluePortalDOWN;
						} else if (tempPortal.getColor() == Color.YELLOW) {
							toPaint = yellowPortalDOWN;
						}
						else if (tempPortal.getColor() == Color.RED) {
							toPaint = redPortalDOWN;
						}
						else if (tempPortal.getColor() == Color.GREEN){
							toPaint = greenPortalDOWN;
						}
						break;
					case LEFT:
						if (tempPortal.getColor() == Color.BLUE) {
							toPaint = bluePortalLEFT;
						} else if (tempPortal.getColor() == Color.YELLOW) {
							toPaint = yellowPortalLEFT;
						}
						else if (tempPortal.getColor() == Color.RED){
							toPaint = redPortalLEFT;
						}
						else if (tempPortal.getColor() == Color.GREEN){
							toPaint = greenPortalLEFT;
						}
						break;
					case RIGHT:
						if (tempPortal.getColor() == Color.BLUE) {
							toPaint = bluePortalRIGHT;
						} else if (tempPortal.getColor() == Color.YELLOW) {
							toPaint = yellowPortalRIGHT;
						}
						else if (tempPortal.getColor() == Color.RED){
							toPaint = redPortalRIGHT;
						}
						else if (tempPortal.getColor() == Color.GREEN){
							toPaint = greenPortalRIGHT;
						}
						break;
					}
					g.drawImage(toPaint, j * 40, i * 40, null);
					break;
				case 'S': // SWITCH
					g.drawImage(weight, j * 40, i * 40, null);
					Image Paint3 = null;
					switch (((Switch)this.gameField.getCell(j, i)).getID()) {
						case 5:
							Paint3 = pinkSwitch;
							break;
						case 4: 
							Paint3 = greenSwitch;
							break;
						case 3:
							Paint3 = blueSwitch;
							break;
						default: 
							Paint3 = weight;
							break;
					}
					g.drawImage(Paint3, j * 40, i * 40, null);
					if (!((Switch) this.gameField.getCell(j, i)).isEmpty())
						g.drawImage(smallBox, j * 40, i * 40, null);
					if (this.gameField.getCell(j, i) == gameField.player.getPosition()) {
						Image playerDirection = getPlayerDir();
						g.drawImage(playerDirection, j * 40, i * 40, null);
					} else if (gameField.replicator != null
							&& this.gameField.getCell(j, i) == gameField.replicator.getPosition()) {
						g.drawImage(replicator, j * 40, i * 40, null);
					}
					else if (this.gameField.getCell(j,i) == gameField.jaffa.getPosition()){
						g.drawImage(getJaffaDir(), j*40, i*40, null);
					}
					break;
				default:
					g.drawImage(normalFloor, j * 40, i * 40, null);
					break;
				}
			}
		}
		g.setColor(java.awt.Color.CYAN);
		g.setFont(new Font("Arial", Font.PLAIN, 18));
		g.drawString("O'Neil zpm: " + gameField.getPlayer().getZpmCount(), 100, 25);
		g.setColor(java.awt.Color.GREEN);
		g.drawString("Jaffa zpm: " + gameField.getJaffa().getZpmCount(), 250, 25);
		
	}

	public void setGameField(GameField gameField) {
		this.gameField = gameField;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int playerX = gameField.getPlayer().getPosition().getX();
		int playerY = gameField.getPlayer().getPosition().getY();
		int jaffaX = 0;
		int jaffaY = 0;
		if (gameField.getJaffa() != null) {
			jaffaX = gameField.getJaffa().getPosition().getX();
			jaffaY = gameField.getJaffa().getPosition().getY();
		} 
		switch (e.getKeyChar()) {
		case 'q':
			gameField.getPlayer().shootFirstPortal(Color.BLUE);
			break;
		case 'e':
			gameField.getPlayer().shootSecondPortal(Color.YELLOW);
			break;
		case '.':
			gameField.getJaffa().shootFirstPortal(Color.RED);
			break;
		case '-':
			gameField.getJaffa().shootSecondPortal(Color.GREEN);
			break;
		case 's':
			if (playerY < gameField.getHeight() - 1 &&
					gameField.getCell(playerX, playerY + 1) != gameField.getJaffa().getPosition()) {
				gameField.getPlayer().moveTo(gameField.getCell(playerX, playerY + 1), Direction.DOWN);
			}
			break;
		case 'a':
			if (playerX > 0 &&
					gameField.getCell(playerX-1, playerY) != gameField.getJaffa().getPosition()) {
				gameField.getPlayer().moveTo(gameField.getCell(playerX - 1, playerY), Direction.LEFT);
			}
			break;
		case 'w':
			if (playerY > 0 &&
					gameField.getCell(playerX, playerY -1) != gameField.getJaffa().getPosition()) {
				gameField.getPlayer().moveTo(gameField.getCell(playerX, playerY - 1), Direction.UP);
			}
			break;
		case 'd':
			if (playerX < gameField.getWidth() - 1 &&
					gameField.getCell(playerX+1, playerY) != gameField.getJaffa().getPosition()) {
				gameField.getPlayer().moveTo(gameField.getCell(playerX + 1, playerY), Direction.RIGHT);
			}
			break;
		// Pressing the F key on a NormalFloor that has a Box on it results in
		// the player picking it up
		// If the player has a box and is standing on an empty NormalFloor the
		// box will be placed on the floor
		case 'f':
			// Checking if the current Cell is a NormalFloor, otherwise moving
			// on to break
			if (gameField.getCell(playerX, playerY) instanceof Switch) {
				if (gameField.getPlayer().getBox() == null) {
					if (!((Switch) gameField.getCell(playerX, playerY)).isEmpty()) {
						// Setting the current box in the players inventory to
						// be the one that was on the floor
						gameField.getPlayer().setBox(((Switch) gameField.getCell(playerX, playerY)).pickUpBox());
					}
				} else {
					// If the NormalFloor has no box on it, the current box is
					// placed then removed from the player's inventory
					if (gameField.getPlayer().getBox() != null) {
						((Switch) gameField.getCell(playerX, playerY)).putDownBox(gameField.getPlayer().getBox());
						gameField.getPlayer().setBox(null);
					}
				}
			} else if (gameField.getCell(playerX, playerY) instanceof NormalFloor) {
				// The scenario of picking up a box from the floor
				if (gameField.getPlayer().getBox() == null) {
					if (((NormalFloor) gameField.getCell(playerX, playerY)).hasBox()) {
						// Setting the current box in the players inventory to
						// be the one that was on the floor
						gameField.getPlayer().setBox(((NormalFloor) gameField.getCell(playerX, playerY)).pickUpBox());
					}
				}
				// Scenario of putting down an already equipped box
				else {
					// If the NormalFloor has no box on it, the current box is
					// placed then removed from the player's inventory
					if (!((NormalFloor) gameField.getCell(playerX, playerY)).hasBox()
							&& gameField.getPlayer().getBox() != null) {
						((NormalFloor) gameField.getCell(playerX, playerY)).putDownBox(gameField.getPlayer().getBox());
						gameField.getPlayer().setBox(null);
					}
				}
			}
			break;
		//Box interacts with Jaffa(player2), same as with Player
		case ',':
			// Checking if the current Cell is a NormalFloor, otherwise moving
			// on to break
			if (gameField.getCell(jaffaX, jaffaY) instanceof Switch) {
				if (gameField.getJaffa().getBox() == null) {
					if (!((Switch) gameField.getCell(jaffaX, jaffaY)).isEmpty()) {
						// Setting the current box in the players inventory to
						// be the one that was on the floor
						gameField.getJaffa().setBox(((Switch) gameField.getCell(jaffaX, jaffaY)).pickUpBox());
					}
				} else {
					// If the NormalFloor has no box on it, the current box is
					// placed then removed from the player's inventory
					if (gameField.getJaffa().getBox() != null) {
						((Switch) gameField.getCell(jaffaX, jaffaY)).putDownBox(gameField.getJaffa().getBox());
						gameField.getJaffa().setBox(null);
					}
				}
			} else if (gameField.getCell(jaffaX, jaffaY) instanceof NormalFloor) {
				// The scenario of picking up a box from the floor
				if (gameField.getJaffa().getBox() == null) {
					if (((NormalFloor) gameField.getCell(jaffaX, jaffaY)).hasBox()) {
						// Setting the current box in the players inventory to
						// be the one that was on the floor
						gameField.getJaffa().setBox(((NormalFloor) gameField.getCell(jaffaX, jaffaY)).pickUpBox());
					}
				}
				// Scenario of putting down an already equipped box
				else {
					// If the NormalFloor has no box on it, the current box is
					// placed then removed from the player's inventory
					if (!((NormalFloor) gameField.getCell(jaffaX, jaffaY)).hasBox()
							&& gameField.getJaffa().getBox() != null) {
						((NormalFloor) gameField.getCell(jaffaX, jaffaY)).putDownBox(gameField.getJaffa().getBox());
						gameField.getJaffa().setBox(null);
					}
				}
			}
			break;
		}
		switch(e.getKeyCode()){
			case KeyEvent.VK_UP:
				if (jaffaY > 0 &&
						gameField.getCell(jaffaX, jaffaY-1) != gameField.getPlayer().getPosition()) {
					gameField.getJaffa().moveTo(gameField.getCell(jaffaX, jaffaY - 1), Direction.UP);
				}
				break;
			case KeyEvent.VK_DOWN:
				if (jaffaY < gameField.getHeight() - 1 &&
						gameField.getCell(jaffaX, jaffaY+1) != gameField.getPlayer().getPosition()) {
					gameField.getJaffa().moveTo(gameField.getCell(jaffaX, jaffaY + 1), Direction.DOWN);
				}
				break;
			case KeyEvent.VK_RIGHT:
				if (jaffaX < gameField.getWidth() - 1 &&
						gameField.getCell(jaffaX+1, jaffaY) != gameField.getPlayer().getPosition()) {
					gameField.getJaffa().moveTo(gameField.getCell(jaffaX + 1, jaffaY), Direction.RIGHT);
				}
				break;
			case KeyEvent.VK_LEFT:
				if (jaffaX > 0 &&
						gameField.getCell(jaffaX-1, jaffaY) != gameField.getPlayer().getPosition()) {
					gameField.getJaffa().moveTo(gameField.getCell(jaffaX - 1, jaffaY), Direction.LEFT);
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
