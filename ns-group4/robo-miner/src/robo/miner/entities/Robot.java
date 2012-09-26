package robo.miner.entities;

import robo.miner.Board;

public class Robot extends Entity {

    public Robot(Board b, int x, int y) {
        super(b, x, y);
    }

    @Override
    public void update(char move) {
        switch (move) {
            case 'L':
                moveLeft();
                break;
            case 'R':
                moveRight();
                break;
            case 'U':
                moveUp();
                break;
            case 'D':
                moveDown();
                break;
            default:
                break;
        }
    }

    @Override
    public String toString() {
        return "R";
    }

    private void moveLeft() {
        Entity element = this.board.getEntity(x - 1, y);
        moveSide(element, 'l');
    }

    private void moveRight() {
        Entity element = this.board.getEntity(x + 1, y);
        moveSide(element, 'r');
    }

    private void moveUp() {
        Entity element = this.board.getEntity(x, y - 1);
        move(element);
    }

    private void moveDown() {
        Entity element = this.board.getEntity(x, y + 1);
        move(element);
    }

    private void move(Entity destination) {
        if (!(destination instanceof Wall) && !(destination.toString()).equals("L")
                && !(destination instanceof Rock)) {
            //INSIDE HERE IS POSSIBLE MOVE

            Empty temp = new Empty(board, x, y);
            this.x = destination.x;
            this.y = destination.y;
            board.updateEntities(this, temp);

            //DIAMOND
            if (destination instanceof Diamond) {
                board.diamondFound();
            }
        }

    }

    private void moveSide(Entity destination, char side) {
        if (!(destination instanceof Wall) && !(destination.toString()).equals("L")) {
            if (destination instanceof Rock) {
                if (side == 'r') {
                    Entity nextToRock = this.board.getEntity(destination.x + 1, destination.y);
                    if (nextToRock instanceof Empty) {
                        Empty temp = new Empty(board, x, y);
                        this.x = destination.x;
                        this.y = destination.y;
                        board.updateEntities(this, temp);
                        
                        Rock movedRock = new Rock(board, destination.x+1, y);
                        destination.x = destination.x + 1;
                        board.updateEntities(destination, movedRock);
                    }
                } else {
                    Entity nextToRock = this.board.getEntity(destination.x - 1, destination.y);
                    if (nextToRock instanceof Empty) {
                        Empty temp = new Empty(board, x, y);
                        this.x = destination.x;
                        this.y = destination.y;
                        board.updateEntities(this, temp);
                        
                        Rock movedRock = new Rock(board, destination.x-1, y);
                        destination.x = destination.x - 1;
                        board.updateEntities(destination, movedRock);
                    }
                }

            } else {
                Empty temp = new Empty(board, x, y);
                this.x = destination.x;
                this.y = destination.y;
                board.updateEntities(this, temp);

                //DIAMOND
                if (destination instanceof Diamond) {
                    board.diamondFound();
                }
            }
        }
    }
}
