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
            if(bellow instanceof Rock || bellow instanceof Diamond){

                Entity right = this.board.getEntity(x+1, y);
                Entity bellowRight = this.board.getEntity(x+1, y+1);
                Entity left = this.board.getEntity(x-1, y);
                Entity bellowLeft = this.board.getEntity(x-1, y+1);
                if((bellowRight instanceof Empty) &&(right instanceof Empty)){
                    
                    this.y = bellowRight.y;
                    this.x = bellowRight.x;
                    board.updateEntities(this, temp);
                    
                    
                        Entity doubleRight = this.board.getEntity(x+2, y);
                        
                        
                        int xDR = doubleRight.x;
                        int yDR = doubleRight.y;
                        Entity drRight = this.board.getEntity(xDR+1, yDR);
                        Entity drBellowRight = this.board.getEntity(xDR+1, yDR+1);
                        Entity drLeft = this.board.getEntity(xDR-1, yDR);
                        Entity drBellowLeft = this.board.getEntity(xDR-1, yDR+1);
                        Entity drBellow = this.board.getEntity(xDR, yDR+1);

                        if (doubleRight instanceof Rock && isAboutToFallLeft(drBellowRight, drRight, drBellowLeft, drLeft, drBellow)) {
                            this.board.getEntities()[yDR][xDR] = new Empty(board, xDR, yDR);
                        }
                    
                }
                else if((bellowLeft instanceof Empty) &&(left instanceof Empty)){
                    
                    this.y = bellowLeft.y;
                    this.x = bellowLeft.x;
                    board.updateEntities(this, temp);
                }
            }
        }
    }
    
    public boolean isAboutToFallLeft(Entity bellowRight, Entity right, Entity bellowLeft, Entity left, Entity bellow){
        if( (bellow instanceof Rock || bellow instanceof Diamond) && // on top of solid thing
            !(bellowRight instanceof Empty) && !(right instanceof Empty) && //
             (bellowLeft instanceof Empty) &&(left instanceof Empty)
          ) {
            return true;
        }
        return false;
    }
    
    
    @Override
    public String toString() {
        return "*";
    }

    @Override
    public Entity myCopy() {
        return new Rock(board, x, y);
    }
    
    
}
