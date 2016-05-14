package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import enums.Direction;
import gameElements.Box;
import gameElements.NormalFloor;
import main.GameField;

public class Test7 {

	@Test
	public void testMain() {
		GameField gameField = new GameField();
		gameField.Initialize(0);
		Box b = new Box(0, 0, 1);
		gameField.getPlayer().setBox(b);
		int resultX = gameField.getPlayer().getPosition().getX() +1;
		int resultY = gameField.getPlayer().getPosition().getY();
		gameField.print();
		gameField.getPlayer().moveTo(gameField.getCell(resultX, resultY), Direction.RIGHT);
		gameField.print();
		((NormalFloor)gameField.getCell(resultX, resultY)).putDownBox(gameField.getPlayer().getBox());
		gameField.getPlayer().moveTo(gameField.getCell(resultX+1, resultY), Direction.RIGHT);
		gameField.print();
		System.out.println(gameField.getCell(resultX,resultY).getImage());
		assertEquals(gameField.getCell(resultX,resultY).getImage(),'B');
	}

}
