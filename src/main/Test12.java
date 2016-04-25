package main;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Test12 {
	@Test
	public void testMain(){
		//setting up the test case
		GameField gamefield = new GameField();
		gamefield.Initialize(12);
		Player ONeil= gamefield.getPlayer();
			int posX = gamefield.getPlayer().getPosition().getX();
			int posY = gamefield.getPlayer().getPosition().getY();
		Switch sw = (Switch) gamefield.getCell(0, 0);//getting a reference to Switch
		
			gamefield.print();
			ONeil.moveTo(gamefield.getCell(--posX,posY), Direction.LEFT);
			gamefield.print();
			ONeil.moveTo(gamefield.getCell(--posX,posY), Direction.LEFT);
			gamefield.print();
			ONeil.moveTo(gamefield.getCell(--posX,posY), Direction.LEFT);
			gamefield.print();
		
		assertEquals(gamefield.getCell(4,0).getImage(),'D');
	}
}
