package tests;

import static org.junit.Assert.*;
import org.junit.Test;

import enums.Direction;
import gameElements.Cell;
import main.GameField;
/**
 * Created by patkovacs on 2016. 04. 24..
 */
public class Test13 {
    @Test
    public void replicatorThroughSpecialWall(){
        GameField gameField = new GameField();
        gameField.Initialize(13);

        Cell specialWall = gameField.getCell(5,4);
        gameField.getReplicator().moveTo(specialWall,Direction.UP);

        assertNotEquals(gameField.getReplicator().getPosition().getY(), specialWall.getY());
    }

    @Test
    public void replicatorThroughWall(){
        GameField gameField = new GameField();
        gameField.Initialize(13);

        Cell wall = gameField.getCell(4,0);
        gameField.getReplicator().moveTo(gameField.getCell(5,0),Direction.RIGHT);
        assertNotEquals(gameField.getReplicator().getPosition(), wall);
    }
}
