package tests;
import static org.junit.Assert.*;
import org.junit.Test;

import enums.Color;
import enums.Direction;
import main.GameField;
/**
 * Created by patkovacs on 2016. 04. 25..
 */
public class Test15 {
    @Test
    public void shootReplicatorWithPortal(){
        GameField gameField = new GameField();
        gameField.Initialize(13);

        gameField.getPlayer().moveTo(gameField.getCell(0,1), Direction.DOWN);
        gameField.getPlayer().shootFirstPortal(Color.BLUE);

        assertEquals(gameField.getReplicator(), null);
    }
}
