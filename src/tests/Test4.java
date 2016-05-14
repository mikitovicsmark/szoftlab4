package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import enums.Direction;
import main.GameField;

public class Test4 {

	@Test
	public void testZpmBack() {
		GameField gameField = new GameField();
		gameField.Initialize(0);
		
		gameField.print();
		
		int x = gameField.getPlayer().getPosition().getX() + 1;
		int y = gameField.getPlayer().getPosition().getY();
		gameField.getPlayer().moveTo(gameField.getCell(x,y), Direction.RIGHT);
		if(gameField.getCell(x,y).getImage()== 'P')
			gameField.getPlayer().kill();
		gameField.print();
		
		x = gameField.getPlayer().getPosition().getX() + 1;
		y = gameField.getPlayer().getPosition().getY();
		gameField.getPlayer().moveTo(gameField.getCell(x,y), Direction.RIGHT);
		if(gameField.getCell(x,y).getImage()== 'P')
			gameField.getPlayer().kill();
		gameField.print();
		
		x = gameField.getPlayer().getPosition().getX();
		y = gameField.getPlayer().getPosition().getY() + 1;
		gameField.getPlayer().moveTo(gameField.getCell(x,y), Direction.DOWN);
		if(gameField.getCell(x,y).getImage()== 'P')
			gameField.getPlayer().kill();
		gameField.print();
		
		x = gameField.getPlayer().getPosition().getX();
		y = gameField.getPlayer().getPosition().getY() + 1;
		gameField.getPlayer().moveTo(gameField.getCell(x,y), Direction.DOWN);
		if(gameField.getCell(x,y).getImage()== 'P')
			gameField.getPlayer().kill();
		gameField.print();
		
		x = gameField.getPlayer().getPosition().getX() + 1;
		y = gameField.getPlayer().getPosition().getY();
		gameField.getPlayer().moveTo(gameField.getCell(x,y), Direction.RIGHT);
		if(gameField.getCell(x,y).getImage()== 'P')
			gameField.getPlayer().kill();
		gameField.print();
		
		x = gameField.getPlayer().getPosition().getX();
		y = gameField.getPlayer().getPosition().getY() - 1;
		gameField.getPlayer().moveTo(gameField.getCell(x,y), Direction.UP);
		if(gameField.getCell(x,y).getImage()== 'P')
			gameField.getPlayer().kill();
		gameField.print();
		
		assertSame('Z' , gameField.getCell(2,2).getImage());
	}

}
