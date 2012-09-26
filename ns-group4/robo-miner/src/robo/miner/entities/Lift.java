package robo.miner.entities;

import robo.miner.Board;

public class Lift extends Entity {
    
    public boolean open = false;
    
    public Lift(Board b, int x, int y) {
        super(b, x, y);
    }
    
    public Lift(Board b, int x, int y, boolean open){
        super(b, x, y);
        this.open = open;
    }

    @Override
    public void update(char input) {
        
    }
    
    @Override
    public String toString() {
        return open ? "O": "L";
    }
}
