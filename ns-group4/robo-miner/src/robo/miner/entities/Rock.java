package robo.miner.entities;

import robo.miner.Board;

public class Rock extends Entity {

    public Rock(Board b, int x, int y) {
        super(b, x, y);
    }

    @Override
    public void update(char input) {
        Entity bellow = this.board.getEntity(x, y+1);
        Empty temp = new Empty(board, x, y);
        
        if(bellow instanceof Empty){
            this.y = bellow.y;            
            board.updateEntities(this, temp);
        }else{
            if(bellow instanceof Rock){

                Entity right = this.board.getEntity(x+1, y);
                Entity bellowRight = this.board.getEntity(x+1, y+1);
                Entity left = this.board.getEntity(x-1, y);
                Entity bellowLeft = this.board.getEntity(x-1, y+1);
                if((bellowRight instanceof Empty) &&(right instanceof Empty)){
                    
                    this.y = bellowRight.y;
                    this.x = bellowRight.x;
                    board.updateEntities(this, temp);
                }
                else if((bellowLeft instanceof Empty) &&(left instanceof Empty)){
                    
                    this.y = bellowLeft.y;
                    this.x = bellowLeft.x;
                    board.updateEntities(this, temp);
                }
            }
        }
    }
    
    @Override
    public String toString() {
        return "*";
    }
}
