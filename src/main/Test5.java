package main;

import static org.junit.Assert.*;

import org.junit.Test;

public class Test5 {

	@Test
	public void testZPMCount() {
		
		GameField gameField = new GameField();
		gameField.Initialize(0);
		
		System.out.println("ZPMs: " + gameField.getPlayer().getZpmCount());
		gameField.print();
		
		int x = gameField.getPlayer().getPosition().getX() + 1;
		int y = gameField.getPlayer().getPosition().getY();
		gameField.getPlayer().moveTo(gameField.getCell(x,y), Direction.RIGHT);
		if(gameField.getCell(x,y).getImage()== 'Z')
			gameField.getPlayer().pickUpZpm();
		System.out.println("ZPMs: " + gameField.getPlayer().getZpmCount());
		gameField.print();
		
		x = gameField.getPlayer().getPosition().getX() + 1;
		y = gameField.getPlayer().getPosition().getY();
		gameField.getPlayer().moveTo(gameField.getCell(x,y), Direction.RIGHT);
		if(gameField.getCell(x,y).getImage()== 'Z')
			gameField.getPlayer().pickUpZpm();
		System.out.println("ZPMs: " + gameField.getPlayer().getZpmCount());
		gameField.print();
		
		x = gameField.getPlayer().getPosition().getX();
		y = gameField.getPlayer().getPosition().getY() + 1;
		gameField.getPlayer().moveTo(gameField.getCell(x,y), Direction.DOWN);
		if(gameField.getCell(x,y).getImage()== 'Z')
			gameField.getPlayer().pickUpZpm();
		System.out.println("ZPMs: " + gameField.getPlayer().getZpmCount());
		gameField.print();
		
		x = gameField.getPlayer().getPosition().getX();
		y = gameField.getPlayer().getPosition().getY() + 1;
		gameField.getPlayer().moveTo(gameField.getCell(x,y), Direction.DOWN);
		if(gameField.getCell(x,y).getImage()== 'Z')
			gameField.getPlayer().pickUpZpm();
		System.out.println("ZPMs: " + gameField.getPlayer().getZpmCount());
		gameField.print();
		
		x = gameField.getPlayer().getPosition().getX();
		y = gameField.getPlayer().getPosition().getY() + 1;
		gameField.getPlayer().moveTo(gameField.getCell(x,y), Direction.DOWN);
		if(gameField.getCell(x,y).getImage()== 'Z')
			gameField.getPlayer().pickUpZpm();
		System.out.println("ZPMs: " + gameField.getPlayer().getZpmCount());
		gameField.print();
		
		assertNotNull(gameField.getPlayer().getZpmCount());
	}
	
	@Test
	public void TestZPMDisappear() {
		GameField gameField = new GameField();
		gameField.Initialize(0);
		
		gameField.print();
		
		int x = gameField.getPlayer().getPosition().getX() + 1;
		int y = gameField.getPlayer().getPosition().getY();
		gameField.getPlayer().moveTo(gameField.getCell(x,y), Direction.RIGHT);
		if(gameField.getCell(x,y).getImage()== 'Z')
			gameField.getPlayer().pickUpZpm();
		gameField.print();
		
		x = gameField.getPlayer().getPosition().getX() + 1;
		y = gameField.getPlayer().getPosition().getY();
		gameField.getPlayer().moveTo(gameField.getCell(x,y), Direction.RIGHT);
		if(gameField.getCell(x,y).getImage()== 'Z')
			gameField.getPlayer().pickUpZpm();
		gameField.print();
		
		x = gameField.getPlayer().getPosition().getX();
		y = gameField.getPlayer().getPosition().getY() + 1;
		gameField.getPlayer().moveTo(gameField.getCell(x,y), Direction.DOWN);
		if(gameField.getCell(x,y).getImage()== 'Z')
			gameField.getPlayer().pickUpZpm();
		gameField.print();
		
		x = gameField.getPlayer().getPosition().getX();
		y = gameField.getPlayer().getPosition().getY() + 1;
		gameField.getPlayer().moveTo(gameField.getCell(x,y), Direction.DOWN);
		if(gameField.getCell(x,y).getImage()== 'Z')
			gameField.getPlayer().pickUpZpm();
		gameField.print();
		
		x = gameField.getPlayer().getPosition().getX();
		y = gameField.getPlayer().getPosition().getY() + 1;
		gameField.getPlayer().moveTo(gameField.getCell(x,y), Direction.DOWN);
		if(gameField.getCell(x,y).getImage()== 'Z')
			gameField.getPlayer().pickUpZpm();
		gameField.print();

		System.out.println(gameField.getCell(2,2).getImage());
		assertEquals('.', gameField.getCell(2,2).getImage());
	}
}