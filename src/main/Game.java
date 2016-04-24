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
			}
			gameField.print();
		}
		scanner.close();

	}

}
