package main;

import static org.junit.Assert.*;

import org.junit.Test;

public class Test8 {

	@Test
	public void testMain() {
		GameField gameField = new GameField();
		gameField.Initialize(0);
		Box b = new Box(0, 0, 2);
		gameField.getPlayer().setBox(b);
		int resultX = gameField.getPlayer().getPosition().getX() +1;
		int resultY = gameField.getPlayer().getPosition().getY();
		gameField.setCell(resultX+1, resultY, new Door(resultX+1,resultY, Color.YELLOW));
		gameField.setCell(resultX, resultY, new Switch(resultX, resultY, 2, (Door)gameField.getCell(resultX+1, resultY)));
		gameField.getPlayer().moveTo(gameField.getCell(resultX, resultY), Direction.RIGHT);
		((Switch)gameField.getCell(resultX, resultY)).putDownBox(gameField.getPlayer().getBox());
		assertEquals(gameField.getCell(resultX+1, resultY).getImage(),'D');
	}

}
