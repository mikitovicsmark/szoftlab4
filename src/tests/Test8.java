package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import enums.Color;
import enums.Direction;
import gameElements.Box;
import gameElements.Door;
import gameElements.Switch;
import main.GameField;

public class Test8 {
	 
 	@Test
 	public void testMain() {
 		GameField gameField = new GameField();
		gameField.Initialize(0);
 		Box b = new Box(0, 0, 2);
 		gameField.getPlayer().setBox(b);
 		int resultX = gameField.getPlayer().getPosition().getX() +1;
 		int resultY = gameField.getPlayer().getPosition().getY();
 		gameField.setCell(resultX+1, resultY, new Door(resultX+1,resultY, Color.YELLOW, 1));
 		gameField.setCell(resultX, resultY, new Switch(resultX, resultY, (Door)gameField.getCell(resultX+1, resultY),2,1)); //int x, int y, Door d, int openWeight, int nwid
 		gameField.getPlayer().moveTo(gameField.getCell(resultX, resultY), Direction.RIGHT);
 		((Switch)gameField.getCell(resultX, resultY)).putDownBox(gameField.getPlayer().getBox());
 		assertEquals(gameField.getCell(resultX+1, resultY).getImage(),'D');
 	}
	 
}


