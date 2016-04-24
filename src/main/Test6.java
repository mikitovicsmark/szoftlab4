package main;

import static org.junit.Assert.*;

import org.junit.Test;

public class Test6 {
	@Test
	public void testPlayerHasBox() {
		GameField gameField = new GameField();
		gameField.Initialize(0);
		
		gameField.print();
		
		int x = gameField.getPlayer().getPosition().getX() + 1;
		int y = gameField.getPlayer().getPosition().getY();
		gameField.getPlayer().moveTo(gameField.getCell(x,y), Direction.RIGHT);
		if(gameField.getCell(x,y).getImage()== 'B')
			gameField.getPlayer().setBox(((NormalFloor) gameField.getCell(x, y)).pickUpBox());
		gameField.print();
		
		x = gameField.getPlayer().getPosition().getX() + 1;
		y = gameField.getPlayer().getPosition().getY();
		gameField.getPlayer().moveTo(gameField.getCell(x,y), Direction.RIGHT);
		if(gameField.getCell(x,y).getImage()== 'B')
			gameField.getPlayer().setBox(((NormalFloor) gameField.getCell(x, y)).pickUpBox());
		gameField.print();
		
		x = gameField.getPlayer().getPosition().getX() + 1;
		y = gameField.getPlayer().getPosition().getY();
		gameField.getPlayer().moveTo(gameField.getCell(x,y), Direction.RIGHT);
		if(gameField.getCell(x,y).getImage()== 'B')
			gameField.getPlayer().setBox(((NormalFloor) gameField.getCell(x, y)).pickUpBox());
		gameField.print();
		
		assertNotNull(gameField.getPlayer().getBox());
	}
	
	@Test
	public void testBoxHasGone() {
		GameField gameField = new GameField();
		gameField.Initialize(0);
		
		gameField.print();
		
		int x = gameField.getPlayer().getPosition().getX() + 1;
		int y = gameField.getPlayer().getPosition().getY();
		gameField.getPlayer().moveTo(gameField.getCell(x,y), Direction.RIGHT);
		if(gameField.getCell(x,y).getImage()== 'B')
			gameField.getPlayer().setBox(((NormalFloor) gameField.getCell(x, y)).pickUpBox());
		gameField.print();
		
		x = gameField.getPlayer().getPosition().getX() + 1;
		y = gameField.getPlayer().getPosition().getY();
		gameField.getPlayer().moveTo(gameField.getCell(x,y), Direction.RIGHT);
		if(gameField.getCell(x,y).getImage()== 'B')
			gameField.getPlayer().setBox(((NormalFloor) gameField.getCell(x, y)).pickUpBox());
		gameField.print();
		
		x = gameField.getPlayer().getPosition().getX() + 1;
		y = gameField.getPlayer().getPosition().getY();
		gameField.getPlayer().moveTo(gameField.getCell(x,y), Direction.RIGHT);
		if(gameField.getCell(x,y).getImage()== 'B')
			gameField.getPlayer().setBox(((NormalFloor) gameField.getCell(x, y)).pickUpBox());
		gameField.print();

		assertSame('.' , gameField.getCell(x,y).getImage());
	}
}

