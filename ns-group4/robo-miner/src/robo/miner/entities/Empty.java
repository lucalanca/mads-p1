package robo.miner.entities;

public class Empty implements Entity {

    @Override
    public void update() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public String toString() {
        return " ";
    }
    
}
