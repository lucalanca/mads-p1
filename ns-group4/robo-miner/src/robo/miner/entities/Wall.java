package robo.miner.entities;

import robo.miner.Board;

public class Wall extends Entity{

    public Wall(Board b, int x, int y) {
        super(b, x, y);
    }

    @Override
    public void update() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public String toString() {
        return "#";
    }
}
