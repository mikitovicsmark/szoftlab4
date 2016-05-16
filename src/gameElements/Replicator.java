package gameElements;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import enums.Direction;
import interfaces.Moving;
import main.GameField;

/**
 * Created by patkovacs on 2016. 04. 23..
 */
public class Replicator extends Player implements Moving{
    private Cell position;
    private char image;
    private GameField field;
    private Direction dir;

    public Replicator(Cell position) {
        super(position);
        this.position = position;
        this.image = 'R';
        dir = Direction.RIGHT;
    }

    public GameField getField() {
        return field;
    }

    public void setField(GameField field) {
        this.field = field;
    }

    public char getImage() {
        return image;
    }

    public void setImage(char image) {
        this.image = image;
    }

    public Cell getPosition() {
        return position;
    }

    public void setPosition(Cell cell) {
        this.position = cell;
    }

    public void die(){
        field.setCell(position.getX(), position.getY(), new NormalFloor(position.getX(), position.getY(), null));
        this.setPosition(field.getCell(position.getX(),position.getY()));
        field.setReplicator(null);
    }

    @Override
    public void moveTo(Cell cell, Direction dir) {
		this.dir = dir;
		this.setPosition(cell);
		cell.interact(this, dir);
    }

    public void randomMove(){
        Random rand = new Random();
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (field.getReplicator() == null){
                    timer.cancel();
                }
                else{
                    //create random direction and move
                    int replicatorX = field.getReplicator().getPosition().getX();
                    int replicatorY = field.getReplicator().getPosition().getY();
                    //rand.nextInt(4)
                    switch(rand.nextInt(4)){
                        case 0:
                            if (replicatorY < field.getHeight() - 1) {
                                field.getReplicator().moveTo(field.getCell(replicatorX, replicatorY + 1), Direction.DOWN);
                            }
                            break;
                        case 1:
                            if (replicatorX > 0) {
                                field.getReplicator().moveTo(field.getCell(replicatorX - 1, replicatorY), Direction.LEFT);
                            }
                            break;
                        case 2:
                            if (replicatorY > 0) {
                                field.getReplicator().moveTo(field.getCell(replicatorX, replicatorY - 1), Direction.UP);
                            }
                            break;
                        case 3:
                            if (replicatorX < field.getWidth() - 1) {
                                field.getReplicator().moveTo(field.getCell(replicatorX + 1, replicatorY), Direction.RIGHT);
                            }
                            break;
                    }
                }
            }
        }, 2*1000, 2*1000);
    }
}
