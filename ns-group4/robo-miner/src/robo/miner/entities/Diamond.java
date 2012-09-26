package robo.miner.entities;

import robo.miner.Board;

public class Diamond extends Entity {

    public Diamond(Board b, int x, int y) {
        super(b, x, y);
    }

    @Override
    public void update() {
        
    }
    
    @Override
    public String toString() {
        return "x";
    }
    
}
