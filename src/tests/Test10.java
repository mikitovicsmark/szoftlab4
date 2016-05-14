package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import enums.Direction;
import gameElements.Cell;
import gameElements.Player;
import main.GameField;

public class Test10 {//Portal usage

	@Test
	public void testMain(){
		//setting up the test case
		GameField gamefield = new GameField();
		gamefield.Initialize(10);
		Player ONeil= gamefield.getPlayer();
		ONeil.bindPortals();
		ONeil.getFirstPortal().setDirection(Direction.LEFT);
		ONeil.getSecondPortal().setDirection(Direction.RIGHT);
			int posX = gamefield.getPlayer().getPosition().getX();
			int posY = gamefield.getPlayer().getPosition().getY();
			
		//Moving O'Neil toward the portal
		ONeil.moveTo(gamefield.getCell(++posX,posY), Direction.RIGHT);
		gamefield.print();
		ONeil.moveTo(gamefield.getCell(++posX,posY), Direction.RIGHT);
		gamefield.print();

		//Testing if ONeil has moved to (5,0)
		Cell postPos= gamefield.getPlayer().getPosition();
		assertEquals(postPos.getX(),5);
		assertEquals(postPos.getY(),posY);
		
	}
}
