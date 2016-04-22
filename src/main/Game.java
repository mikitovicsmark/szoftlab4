package main;

import java.util.Scanner;

public class Game {
	public static void main(String[] args) {

		GameField gameField = new GameField();
		gameField.Initialize(new Serializer().loadMap(0));
		boolean exit = false;
		Scanner scanner = new Scanner(System.in);

		gameField.print();

		while (scanner.hasNext() && !exit) {

			int playerX = gameField.getPlayer().getPosition().getX();
			int playerY = gameField.getPlayer().getPosition().getY();
			// System.out.println("playerX :"+playerX+" playerY :"+playerY);
			switch (scanner.next()) {
			case "s":
				if (playerY < gameField.getHeight() - 1) {
					gameField.getPlayer().moveTo(gameField.getCell(playerX, playerY + 1), Direction.DOWN);
				}
				break;
			case "a":
				if (playerX > 0) {
					gameField.getPlayer().moveTo(gameField.getCell(playerX - 1, playerY), Direction.RIGHT);
				}
				break;
			case "w":
				if (playerY > 0) {
					gameField.getPlayer().moveTo(gameField.getCell(playerX, playerY - 1), Direction.UP);
				}
				break;
			case "d":
				if (playerX < gameField.getWidth() - 1) {
					gameField.getPlayer().moveTo(gameField.getCell(playerX + 1, playerY), Direction.LEFT);
				}
				break;
			}
			gameField.print();
		}
		scanner.close();

	}

}
