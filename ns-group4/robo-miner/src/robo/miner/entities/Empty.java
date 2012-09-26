package robo.miner.entities;

import robo.miner.Board;

public class Empty extends Entity {

    public Empty(Board b, int x, int y) {
        super(b, x, y);
    }

    @Override
    public void update(char input) {
        
    }
    
    @Override
    public String toString() {
        return " ";
    }

    @Override
    public Entity myCopy() {
        return new Empty(board, x, y);
    }
}
