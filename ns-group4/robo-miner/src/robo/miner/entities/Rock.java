package robo.miner.entities;

import robo.miner.Board;

public class Rock extends Entity {

    public Rock(Board b, int x, int y) {
        super(b, x, y);
    }

    @Override
    public void update(char input) {
        Entity bellow = this.board.getEntity(x, y+1);
        if(bellow instanceof Empty){
            Empty temp = new Empty(board, x, y);
            
            this.y = bellow.y;
            
            board.updateEntities(this, temp);
        }
    }
    
    @Override
    public String toString() {
        return "*";
    }
}
