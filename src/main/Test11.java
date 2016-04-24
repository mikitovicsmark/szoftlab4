package main;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Test11 {
	
	@Test
	public void testMain(){
		//setting up the test case
		GameField gamefield = new GameField();
		gamefield.Initialize(11);
		Player ONeil= gamefield.getPlayer();
			int posX = gamefield.getPlayer().getPosition().getX();
			int posY = gamefield.getPlayer().getPosition().getY();
		Exit  ex = (Exit)gamefield.getCell(3, 0);
		ex.openExit();//opening the exit for test purpose
		
		ONeil.moveTo(gamefield.getCell(++posX,posY), Direction.RIGHT);
		gamefield.print();
		ONeil.moveTo(gamefield.getCell(++posX,posY), Direction.RIGHT);
		gamefield.print();
		ONeil.moveTo(gamefield.getCell(++posX,posY), Direction.RIGHT);
		gamefield.print();
		
		assertEquals(gamefield.getCell(posX,posY).getImage(),'e');
		
	}
}
