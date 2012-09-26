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
        move(element);
    }

    private void moveRight() {
        Entity element = this.board.getEntity(x + 1, y);
        move(element);
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
}
