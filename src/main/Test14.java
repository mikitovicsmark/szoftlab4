package main;
import static org.junit.Assert.*;
import org.junit.Test;
/**
 * Created by patkovacs on 2016. 04. 25..
 */
public class Test14 {
    @Test
    public void replicatorInteractPit(){
        GameField gameField = new GameField();
        gameField.Initialize(13);

        Cell pit = gameField.getCell(9,0);
        gameField.getReplicator().moveTo(pit,Direction.UP);
        gameField.print();
        assertEquals(null, gameField.getReplicator());
        assertEquals('.', gameField.getCell(9,0).getImage());
    }
}
