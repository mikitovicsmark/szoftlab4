package main;

import java.io.IOException;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Random;

public class Game {
	public static void main(String[] args) {

		GameField gameField = new GameField();
		gameField.Initialize(0);
		boolean exit = false;
		Scanner scanner = new Scanner(System.in);

		gameField.print();

		//random move of Replicator
		gameField.getReplicator().randomMove();

		while (scanner.hasNext() && !exit) {

			int playerX = gameField.getPlayer().getPosition().getX();
			int playerY = gameField.getPlayer().getPosition().getY();
			switch (scanner.next()) {
			case "q":
				gameField.getPlayer().shootFirstPortal(Color.BLUE);
				break;
			case "e":
				gameField.getPlayer().shootSecondPortal(Color.YELLOW);
				break;
			case "s":
				if (playerY < gameField.getHeight() - 1) {
					gameField.getPlayer().moveTo(gameField.getCell(playerX, playerY + 1), Direction.DOWN);
				}
				break;
			case "a":
				if (playerX > 0) {
					gameField.getPlayer().moveTo(gameField.getCell(playerX - 1, playerY), Direction.LEFT);
				}
				break;
			case "w":
				if (playerY > 0) {
					gameField.getPlayer().moveTo(gameField.getCell(playerX, playerY - 1), Direction.UP);
				}
				break;
			case "d":
				if (playerX < gameField.getWidth() - 1) {
					gameField.getPlayer().moveTo(gameField.getCell(playerX + 1, playerY), Direction.RIGHT);
				}
				break;
				//Pressing the F key on a NormalFloor that has a Box on it results in the player picking it up
				//If the player has a box and is standing on an empty NormalFloor the box will be placed on the floor
			case "f":
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
			gameField.print();
		}
		scanner.close();

	}

}
