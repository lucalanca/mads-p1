package robo.miner.entities;

import robo.miner.Board;

public class Earth extends Entity {

    public Earth(Board b, int x, int y) {
        super(b, x, y);
    }

    @Override
    public void update() {
        
    }

    @Override
    public String toString() {
        return ".";
    }
    
}
