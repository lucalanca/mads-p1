package robo.miner;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Game implements Runnable {
    
    Board board = new Board();
    static char input = 'W';
    public static void main(String[] args) {
        Game game = new Game();
        Thread t = new Thread(game);
        t.start();
        Scanner scanner = new Scanner(System.in);
        while(true){
            if(scanner.hasNext()) {
                input = scanner.next().toUpperCase().charAt(0);
            }
            else {
                input = 'W';
            }
        }
    }

    @Override
    public void run() {
        board.createFromFile("files/example6.map");
        System.out.println(board.drawMap());

        
        while(true) {
            try {
                Thread.sleep(1000);
                //input
                board.update(input); //input here later on
                System.out.println(board.drawMap());
                System.out.println("input: " + input);
                input = 'W';                
            } catch (InterruptedException ex) {
                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
}
