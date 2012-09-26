package robo.miner.entities;

import robo.miner.Board;

public class Robot extends Entity {

    public Robot(Board b, int x, int y) {
        super(b, x, y);
    }

    @Override
    public void update() {
        
    }
    
    @Override
    public String toString() {
        return "R";
    }
    
}
