package robo.miner.entities;

public class Lift implements Entity {
    
    public boolean open = false;

    @Override
    public void update() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public String toString() {
        return open ? "O": "L";
    }
}
