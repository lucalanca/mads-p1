package robo.miner.entities;

import robo.miner.Board;

public abstract class Entity {
    public int x = 0;
    public int y = 0;
    public Board board;
    public abstract void update();
    

    public Entity(Board b, int x, int y) {
        this.board = b;
        this.x = x;
        this.y = y;
    }
    
    
}
