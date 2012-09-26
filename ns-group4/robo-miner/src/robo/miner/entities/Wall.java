package robo.miner.entities;

import robo.miner.Board;

public class Wall extends Entity{

    public Wall(Board b, int x, int y) {
        super(b, x, y);
    }

    @Override
    public void update(char input) {
        
    }
    
    @Override
    public String toString() {
        return "#";
    }
}
