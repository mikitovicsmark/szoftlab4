package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import enums.Color;
import enums.Direction;
import gameElements.SpecialWall;
import gameElements.Wall;
import main.GameField;

public class Test9 {

	@Test
	public void test() {
		GameField gameField = new GameField();
		gameField.Initialize(0);
		int i=0;
		
		int nonSpecialX=4;
		int nonSpecialY=0;
		
		gameField.getPlayer().moveTo(gameField.getCell(gameField.getPlayer().getPosition().getX()+1,gameField.getPlayer().getPosition().getY()), Direction.RIGHT);
		gameField.getPlayer().shootFirstPortal(Color.BLUE);
		assertTrue(gameField.getCell(nonSpecialX, nonSpecialY) instanceof Wall);
		assertFalse(gameField.getCell(nonSpecialX, nonSpecialY) instanceof SpecialWall);
		assertEquals(gameField.getCell(nonSpecialX,nonSpecialY).getImage(),'|');

		
	}

}
