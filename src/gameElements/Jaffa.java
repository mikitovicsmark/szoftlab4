package gameElements;

import enums.Direction;
import interfaces.Moving;
import main.GameField;

/**
 * Created by patkovacs on 2016. 05. 15..
 */
public class Jaffa extends Player{
    public Jaffa(Cell position) {
        super(position);
        this.setImage('J');
    }
}
